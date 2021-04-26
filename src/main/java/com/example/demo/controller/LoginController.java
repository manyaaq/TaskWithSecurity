package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class LoginController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRoleRepository userRoleRepository;

    @Secured("ROLE_USER")
    @GetMapping("/login")
    public User login(Principal principal){
        return userRepository.findByUsername(principal.getName());
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        userRoleRepository.save(new UserRole("ROLE_USER", user));
        return userRepository.save(user);
    }
}
