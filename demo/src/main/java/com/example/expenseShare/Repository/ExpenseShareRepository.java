package com.example.expenseShare.Repository;

import com.example.expenseShare.model.Expense;
import com.example.expenseShare.model.ExpenseShare;
import com.example.expenseShare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseShareRepository extends JpaRepository<ExpenseShare,Long> {
    List<ExpenseShare> findByExpense(Expense expense);
    List<ExpenseShare> findByUser(User user);
}
