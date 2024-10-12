package com.ust.ExpenseTracker.controller;

import com.ust.ExpenseTracker.model.UserCred;
import com.ust.ExpenseTracker.service.JwtService;
import com.ust.ExpenseTracker.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    AuthenticationManager authManager;

    @PostMapping("register")
    public UserCred register(@RequestBody UserCred userCred){
        return userService.saveUser(userCred);
    }

    @PostMapping("login")
    public String login(@RequestBody UserCred userCred){
        Authentication authentication=authManager.authenticate(new UsernamePasswordAuthenticationToken(userCred.getUsername(),userCred.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(userCred.getUsername());
        } else {
            throw new RuntimeException("invalid access");
        }

    }


}
