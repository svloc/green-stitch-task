package com.green.stitch.task.greenstitch.controller;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.green.stitch.task.greenstitch.model.User;
import com.green.stitch.task.greenstitch.repository.UserRepository;


@RestController
public class LoginController {
    @Autowired
    private UserRepository userRepository;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found");
        }

        if (!existingUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
        }

        return ResponseEntity.ok().body("{\"message\": \"Login successful\"}");
    }

    @PostMapping("/signup")
    public User createUser(@RequestBody User user) {
        // if (userRepository.findByEmail(user.getEmail()) != null) {
        //     return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
        // }
        // user.setPassword(passwordEncoder().encode(user.getPassword()));
        // userRepository.save(user);
        // return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        return userRepository.save(user);
    }
    
    // @Bean
    // public BCryptPasswordEncoder passwordEncoder(){ 
    //     return new BCryptPasswordEncoder(); 
    // }

}
