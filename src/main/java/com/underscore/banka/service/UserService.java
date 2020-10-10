package com.underscore.banka.service;


import com.underscore.banka.dto.UserDTO;
import com.underscore.banka.model.User;
import com.underscore.banka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<User> register(UserDTO userDTO) {
        passwordEncoder.encode(userDTO.getPassword());
        User user = userRepository.save(new User(userDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    public ResponseEntity<Object> viewUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());
    }


}
