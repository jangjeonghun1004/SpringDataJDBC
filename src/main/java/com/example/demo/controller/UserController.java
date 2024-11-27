package com.example.demo.controller;

import com.example.demo.Repository.UserRepository;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping
    public String createUser(@RequestBody User user) {
        int queryResult = this.userRepository.save(user);
        System.out.println(queryResult);

        return "User created successfully";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam Long id, @RequestParam String userid) {
        int queryResult = this.userRepository.updateUser(id, userid);
        System.out.println(queryResult);

        return "User updated successfully";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam Long id) {
        int queryResult = this.userRepository.deleteUser(id);
        System.out.println(queryResult);

        return "User delete successfully";
    }

    @GetMapping
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        try {
            return this.userRepository.findById(id);
        } catch (Exception e) {
            throw new CustomDatabaseException("Error fetching users from database", e);
        }
    }

    @ExceptionHandler(CustomDatabaseException.class)
    public ResponseEntity<String> handleCustomDatabaseException(CustomDatabaseException ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("A database error occurred: " + ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An unexpected error occurred: " + ex.getMessage());
    }
}
