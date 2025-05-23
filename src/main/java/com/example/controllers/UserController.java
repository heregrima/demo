package com.example.controllers;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.models.Role;
import com.example.models.User;
import com.example.repositories.RoleRepository;
import com.example.repositories.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected RoleRepository roleRepository;

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
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        // get user object by Id
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User userRequest) {
        userRepository.save(userRequest);

        /* 
        // Creates a new user
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        
        // save the user
        userRepository.save(user);
        */

        // set up the return URI for the response based on the id of the newly created User
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(userRequest.getId())
            .toUri();
        // return the 201 response with the URI and the user object created
        return ResponseEntity.created(location).body(userRequest);
    }

    @PostMapping("{id}/roles/{roleId}")
    public ResponseEntity<User> addRoleToUser(@PathVariable Long userId, @PathVariable Long roleId) {
        // get the user from the id passed in the URI
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        // get the role from the id passed in the URI
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role not found"));
        // add the role to the user roles
        user.getRoles().add(role);
        // save the user with the new role
        userRepository.save(user);
        
        // give an okay response (200)
        return ResponseEntity.ok(user);
    }
    
    
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userRequest) {
        // Updates an existing user
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());

        return user;
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id) {
        userRepository.deleteById(id);

        return "Deleted";
    }
    
}
