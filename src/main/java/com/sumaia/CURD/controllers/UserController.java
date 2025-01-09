package com.sumaia.CURD.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sumaia.CURD.entities.User;
import com.sumaia.CURD.repositories.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserRepository userRepo;
    
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        user.setPassword(user.getPassword()); // Hashing logic can be added
        userRepo.save(user);
        return ResponseEntity.ok("User added successfully");
    }

    @GetMapping("/details/{userId}")
    public ResponseEntity<?> getUser(@PathVariable Long userId) {
        Optional<User> user = userRepo.findById(userId);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        if (userRepo.existsById(userId)) {
            userRepo.deleteById(userId);
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody User updateUser) {
        Optional<User> userOptional = userRepo.findById(updateUser.getId());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (updateUser.getFirstName() != null) user.setFirstName(updateUser.getFirstName());
            if (updateUser.getLastName() != null) user.setLastName(updateUser.getLastName());
            if (updateUser.getEmail() != null) user.setEmail(updateUser.getEmail());
            if (updateUser.getPassword() != null) user.setPassword(updateUser.getPassword());
            userRepo.save(user);
            return ResponseEntity.ok("User updated successfully");
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }
}
