package com.patika.bloghubuserservice.service;

import com.patika.bloghubuserservice.client.email.service.EmailClientService;
import com.patika.bloghubuserservice.client.email.service.dto.request.enums.EmailTemplate;
import com.patika.bloghubuserservice.constant.ExceptionMessages;
import com.patika.bloghubuserservice.converter.UserConverter;
import com.patika.bloghubuserservice.producer.dto.SendEmailMessage;
import com.patika.bloghubuserservice.dto.request.UserSaveRequest;
import com.patika.bloghubuserservice.dto.response.UserResponse;
import com.patika.bloghubuserservice.exception.BusinessException;
import com.patika.bloghubuserservice.model.User;
import com.patika.bloghubuserservice.model.enums.StatusType;
import com.patika.bloghubuserservice.producer.RabbitMQProducer;
import com.patika.bloghubuserservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    private final EmailClientService emailClientService;

    private final RabbitMQProducer rabbitMQProducer;

    public UserResponse saveUser(UserSaveRequest request) {

        if (request.getEmail() == null) {
            log.error("request: {},", request + "\n" + ExceptionMessages.USER_EMAIL_CAN_NOT_BE_EMPTY);
            throw new BusinessException(ExceptionMessages.USER_EMAIL_CAN_NOT_BE_EMPTY);
        }

        Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());

        if (optionalUser.isPresent()) {
            throw new BusinessException(ExceptionMessages.USER_ALREADY_DEFINED);
        } else {
            User savedUser = new User(request.getEmail(), request.getPassword()); // ödev password hash'le

            userRepository.save(savedUser);


            rabbitMQProducer.sendEmail(new SendEmailMessage(request.getEmail(), EmailTemplate.CREATE_USER_TEMPLATE));

            return UserConverter.toResponse(savedUser);

        }
    }


    public UserResponse getUserByEmail(String email) {

        User foundUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessException(ExceptionMessages.USER_NOT_FOUND));

        return UserConverter.toResponse(foundUser);

    }

    public List<UserResponse> getAllUsers() {

        log.info("get all users methodu çağrıldı");

        List<User> users = userRepository.findAll();

        return UserConverter.toResponse(users);

    }

    public void changeStatus(String email, StatusType statusType) {
        Optional<User> foundUser = userRepository.findByEmail(email);

        foundUser.get().setStatusType(statusType);

//        paymentClientService.createPayment(new PaymentRequest(new BigDecimal("9.99"), email));

//        userRepository.changeStatus(email, foundUser.get());
    }

// örneklendirme için
    /*
    public void changeStatus(List<String> emailList, StatusType statusType) {

        Map<String, User> allUsersMap = getAllUsersMap();

        emailList.forEach(email -> {
            User user = allUsersMap.get(email);
            user.setStatusType(statusType);
        });
    }
    */


    public void changeStatusBulk(List<String> emailList, StatusType statusType) {
        emailList.forEach(email -> changeStatus(email, statusType));
    }

    public Map<String, User> getAllUsersMap() {
        return userRepository.findAll()
                .stream()
                .collect(Collectors.toMap(User::getEmail, Function.identity()));
    }
}
