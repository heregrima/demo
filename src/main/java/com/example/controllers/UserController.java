package com.example.demo.controllers;

import com.example.demo.modle.User;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("")
    public String healthCheck() {
        // healthcheck
        return "user is getting hit correctly";
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable Long id) {
        // get user object by Id
        User user = new User();
        return user;
    }

    @PostMapping
    public User createUser(@RequestBody User userRequest) {
        // Creates a new user
        User user = new User();
        return user;
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userRequest) {
        // Updates an existing user
        User user = new User();
        return user;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        // Deletes a user
    }
    
}
