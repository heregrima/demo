package com.example.services;

import java.util.List;

import com.example.models.Role;
import com.example.repositories.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RoleService {

    @Autowired
    private RoleRepository RoleRepository;

    public List<Role> getAllUsers() {
        return RoleRepository.findAll();
    }
}