package com.example.controllers;

import java.net.URI;

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
import com.example.repositories.RoleRepository;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    protected RoleRepository roleRepository;

    @GetMapping("/health")
    public String healthCheck() {
        // healthcheck
        return "role is getting hit correctly";
    }

    @GetMapping("")
    public @ResponseBody Iterable<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
        // get role object by Id
        Role role = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
        return ResponseEntity.ok(role);
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role roleRequest) {
        // Creates a new role
        Role role = new Role();
        role.setRoleName(roleRequest.getRoleName());
        
        roleRepository.save(role);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(role.getId())
            .toUri();
        // return the 201 response with the URI and the user object created

        return ResponseEntity.created(location).body(role);
    }

    @PutMapping("/{id}")
    public Role updateRole(@PathVariable Long id, @RequestBody Role roleRequest) {
        // Updates an existing role
        Role role = new Role();
        role.setRoleName(roleRequest.getRoleName());

        return role;
    }

    @DeleteMapping("/{id}")
    public String deleteRoleById(@PathVariable Long id) {
        roleRepository.deleteById(id);

        return "Deleted";
    }
    
}
