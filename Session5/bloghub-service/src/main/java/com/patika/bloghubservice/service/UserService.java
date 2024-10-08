package com.patika.bloghubservice.service;

import com.patika.bloghubservice.client.email.service.dto.request.enums.EmailTemplate;
import com.patika.bloghubservice.client.email.service.EmailClientService;
import com.patika.bloghubservice.client.payment.service.PaymentClientService;
import com.patika.bloghubservice.client.payment.service.dto.request.PaymentRequest;
import com.patika.bloghubservice.converter.UserConverter;
import com.patika.bloghubservice.dto.producer.SendEmailMessage;
import com.patika.bloghubservice.dto.request.UserSaveRequest;
import com.patika.bloghubservice.dto.response.UserResponse;
import com.patika.bloghubservice.exception.BusinessException;
import com.patika.bloghubservice.constant.ExceptionMessages;
import com.patika.bloghubservice.model.User;
import com.patika.bloghubservice.model.enums.StatusType;
import com.patika.bloghubservice.producer.RabbitMQProducer;
import com.patika.bloghubservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    private final PaymentClientService paymentClientService;

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

            // emailClientService.sendEmail(new EmailCreateRequest(request.getEmail(), EmailTemplate.CREATE_USER_TEMPLATE));

            return UserConverter.toResponse(savedUser);
        }
    }


    public UserResponse getUserByEmail(String email) {

        User foundUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException(ExceptionMessages.USER_NOT_FOUND));

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

        paymentClientService.createPayment(new PaymentRequest(new BigDecimal("9.99"), email));

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
