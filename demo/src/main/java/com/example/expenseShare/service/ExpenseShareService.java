package com.example.expenseShare.service;

import com.example.expenseShare.Repository.ExpenseRepository;
import com.example.expenseShare.Repository.ExpenseShareRepository;
import com.example.expenseShare.Repository.UserRepository;
import com.example.expenseShare.model.Expense;
import com.example.expenseShare.model.ExpenseShare;
import com.example.expenseShare.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseShareService {
    @Autowired
    private ExpenseShareRepository expenseShareRepository;
    @Autowired
    private ExpenseRepository expenseRepo;

    @Autowired
    private UserRepository userRepo;

    public List<ExpenseShare>getAllExpenses(){
        return expenseShareRepository.findAll();
    }
    public List<ExpenseShare> getSharesByExpense(Long expenseId) {
        Expense expense=expenseRepo.findById(expenseId).orElseThrow(() -> new RuntimeException("Expense not found: " + expenseId));
        return expenseShareRepository.findByExpense(expense);
    }

    public List<ExpenseShare> getSharesByUser(Long userId) {
        User user=userRepo.findById(userId).orElseThrow(()->new RuntimeException("User not found: " + userId));
        return expenseShareRepository.findByUser(user);
    }
    public double getTotalOwedByUser(Long userId) {
        List<ExpenseShare> shares = getSharesByUser(userId);

        return shares.stream()
                .mapToDouble(ExpenseShare::getAmountOwed)
                .sum();
    }



    public double getTotalOwedForExpense(Long expenseId) {
        List<ExpenseShare> shares = getSharesByExpense(expenseId);

        return shares.stream()
                .mapToDouble(ExpenseShare::getAmountOwed)
                .sum();
    }
}
