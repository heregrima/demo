package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    protected UserRepository userRepository;

    @GetMapping("/health")
    public String healthCheck() {
        // healthcheck
        return "user is getting hit correctly";
    }

    @GetMapping("")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable Long id) {
        // get user object by Id
        Optional<User> user;
        user = userRepository.findById(id);
        return user.isPresent() ? user.get() : null;
    }

    @PostMapping
    public String createUser(@RequestBody User userRequest) {
        // Creates a new user
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setRole(userRequest.getRole());
        
        userRepository.save(user);

        return "Saved";
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
