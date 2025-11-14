package com.example.expenseShare.controller;

import com.example.expenseShare.model.Expense;
import com.example.expenseShare.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/expenses")

public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/add")
    public Expense addExpense(@RequestBody Map<String, Object> payload) {
        Long paidById = Long.valueOf(payload.get("paidById").toString());
        String description = payload.get("description").toString();
        double amount = Double.parseDouble(payload.get("amount").toString());
        List<Integer> participants = (List<Integer>) payload.get("participants");

        return expenseService.addExpense(
                paidById,
                description,
                amount,
                participants.stream().map(Long::valueOf).collect(Collectors.toList())
        );
    }
    @GetMapping("/{id}")
    public Expense findById(@PathVariable Long id){
        return  expenseService.getExpenseById(id);
    }
    @GetMapping("/all")
    public List<Expense> getAllExpense(){
       return expenseService.getAllExpense();
    }
}
