package com.example.expenseShare.service;

import com.example.expenseShare.repository.ExpenseRepository;
import com.example.expenseShare.repository.ExpenseShareRepository;
import com.example.expenseShare.repository.UserRepository;
import com.example.expenseShare.model.Expense;
import com.example.expenseShare.model.ExpenseShare;
import com.example.expenseShare.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private ExpenseRepository expenseRepo;
    @Autowired
    private ExpenseShareRepository shareRepo;
    @Autowired
    private CategoryPredictor categoryPredictor;


    public Expense addExpense(Long paidById, String description, double amount, List<Long> participants){
        User payer = userRepo.findById(paidById)
                .orElseThrow(() -> new RuntimeException("Payer not found with ID: " + paidById));

        Expense expense = new Expense();
        expense.setDescription(description);
        expense.setAmount(amount);
        expense.setPaidBy(payer);
        expenseRepo.save(expense);
        expense.setCategory(categoryPredictor.predictCategory(description));

        expenseRepo.save(expense);


        int oweCount = (int) participants.stream()
                .filter(id -> !id.equals(paidById))
                .count();

        double share = amount / oweCount;
        for(Long userId: participants){
            if(userId.equals(paidById)){
                continue;
            }

            User A = userRepo.findById(userId).orElseThrow();
            ExpenseShare es=new ExpenseShare();
            es.setExpense(expense);
            es.setUser(A);
            es.setAmountOwed(share);
            shareRepo.save(es);
        }
        return expense;
    }

    public Expense getExpenseById(Long id){
       return expenseRepo.findById(id).orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));

    }
    public List<Expense> getAllExpense(){
       return expenseRepo.findAll();
    }

}
