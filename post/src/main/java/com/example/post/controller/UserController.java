package com.example.post.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.post.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/TO")
public class UserController {
    
    @PostMapping("/user")
        public ResponseEntity<User> createUser(@RequestBody User user) {

            try {
                ObjectMapper objectMapper = new ObjectMapper();
                String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
                System.out.println("Received User JSON: " + jsonString);
            } catch (Exception e) {
                System.err.println("Error converting User to JSON: " + e.getMessage());
            }

        // Return the user data as a JSON response
        return ResponseEntity.ok(user);
    }
}
