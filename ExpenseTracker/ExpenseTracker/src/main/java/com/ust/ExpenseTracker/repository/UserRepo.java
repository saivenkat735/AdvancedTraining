package com.ust.ExpenseTracker.repository;

import com.ust.ExpenseTracker.model.UserCred;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface UserRepo extends JpaRepository<UserCred,Integer> {
    UserCred findByUsername(String username);
}
