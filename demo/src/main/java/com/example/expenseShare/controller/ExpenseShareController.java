package com.example.expenseShare.controller;

import com.example.expenseShare.model.ExpenseShare;
import com.example.expenseShare.service.ExpenseShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/expenseShare")
public class ExpenseShareController {

    @Autowired
    private ExpenseShareService expenseShareService;

    @GetMapping("/all")
    public List<ExpenseShare> getAllExpenseShares() {
        return expenseShareService.getAllExpenses();
    }
    @GetMapping("/user/{userId}")
    public List<ExpenseShare>getSharesByUser(@PathVariable Long userId) {
        return expenseShareService.getSharesByUser(userId);
    }

    @GetMapping("/expense/{expenseId}")
    public List<ExpenseShare> getSharesByExpense(@PathVariable Long expenseId) {
        return expenseShareService.getSharesByExpense(expenseId);
    }
    @GetMapping("/user/{userId}/total-owed")
    public Double getTotalOwedByUser(@PathVariable Long userId) {
    return expenseShareService.getTotalOwedByUser(userId);
}



    @GetMapping("/expense/{expenseId}/total-owed")
    public Double getTotalOwedForExpense(@PathVariable Long expenseId) {
    return expenseShareService.getTotalOwedForExpense(expenseId);
}
}