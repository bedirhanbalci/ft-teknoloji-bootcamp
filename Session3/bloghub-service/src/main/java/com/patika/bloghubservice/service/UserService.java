package com.patika.bloghubservice.service;

import com.patika.bloghubservice.converter.UserConverter;
import com.patika.bloghubservice.dto.request.UserSaveRequest;
import com.patika.bloghubservice.dto.response.UserResponse;
import com.patika.bloghubservice.model.User;
import com.patika.bloghubservice.model.enums.StatusType;
import com.patika.bloghubservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse saveUser(UserSaveRequest request) {

        User savedUser = new User(request.getEmail(), request.getPassword()); // ödev password hash'le

        userRepository.save(savedUser);

        return UserConverter.toResponse(savedUser);

    }

    public UserResponse getUserByEmail(String email) {

        User foundUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("user bulunamadi"));

        return UserConverter.toResponse(foundUser);

    }

    public List<UserResponse> getAllUsers() {

        List<User> users = userRepository.findAll();

        return UserConverter.toResponse(users);

    }

    public void changeStatus(String email, StatusType statusType) {
        Optional<User> foundUser = userRepository.findByEmail(email);

        foundUser.get().setStatusType(statusType);

        userRepository.changeStatus(email, foundUser.get());
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
