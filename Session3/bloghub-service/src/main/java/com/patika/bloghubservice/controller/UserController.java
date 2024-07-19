package com.patika.bloghubservice.controller;

import com.patika.bloghubservice.dto.request.UserSaveRequest;
import com.patika.bloghubservice.dto.response.UserResponse;
import com.patika.bloghubservice.model.enums.StatusType;
import com.patika.bloghubservice.service.UserService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody UserSaveRequest request) {
        return userService.saveUser(request);
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserResponse> getUserByEmail(@PathVariable String email) {
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{email}")
    public void changeStatus(@PathVariable String email, @PathParam("statusType") StatusType statusType) {
        userService.changeStatus(email, statusType);
    }

    @PutMapping()
    public void changeStatus() {
        //  userService.changeStatusBulk(); ödev
    }

    // ödev şifre değiştiren end-point
}
