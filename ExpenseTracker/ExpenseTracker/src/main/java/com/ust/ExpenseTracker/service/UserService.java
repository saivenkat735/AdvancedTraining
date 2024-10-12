package com.ust.ExpenseTracker.service;

import com.ust.ExpenseTracker.model.UserCred;
import com.ust.ExpenseTracker.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    public UserCred saveUser(UserCred userCred){
        userCred.setPassword(encoder.encode(userCred.getPassword()));
        System.out.println(userCred.getPassword());
        return userRepo.save(userCred);
    }


}
