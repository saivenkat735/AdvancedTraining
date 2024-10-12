package com.ust.ExpenseTracker.service;

import com.ust.ExpenseTracker.model.UserCred;
import com.ust.ExpenseTracker.model.UserPrincipal;
import com.ust.ExpenseTracker.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service

public class MyUserDetailsService implements UserDetailsService{
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCred userCred=userRepo.findByUsername(username);
        if(userCred==null){
            System.out.println("user 404");
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(userCred);
    }
}
