package com.underscore.banka.controller;

import com.underscore.banka.dto.UserDTO;
import com.underscore.banka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserDTO userDTO) {
        return userService.register(userDTO);
    }

    @GetMapping
    public ResponseEntity<?> retrieve() {
        return userService.viewUsers();
    }
}
