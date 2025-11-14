package com.example.expenseShare.service;

import com.example.expenseShare.Repository.ExpenseRepository;
import com.example.expenseShare.Repository.ExpenseShareRepository;
import com.example.expenseShare.Repository.UserRepository;
import com.example.expenseShare.model.Expense;
import com.example.expenseShare.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;



    public User addUser(String theUser,String email){
        User user = new User();
        user.setUser(theUser);
        user.setEmail(email);
        return userRepo.save(user);
    }
    public List<User>getAllUsers(){
        return userRepo.findAll();
    }
    public User findById(Long id){
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }
}
