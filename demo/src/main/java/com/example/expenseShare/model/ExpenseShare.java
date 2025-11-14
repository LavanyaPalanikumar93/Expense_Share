package com.example.expenseShare.model;

import jakarta.persistence.*;

@Entity
@Table(name = "expense_share")
public class ExpenseShare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Expense expense;

    @ManyToOne
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmountOwed() {
        return amountOwed;
    }

    public void setAmountOwed(double amountOwed) {
        this.amountOwed = amountOwed;
    }

    private double amountOwed;

    public ExpenseShare(Expense expense, User user, double amountOwed) {
        this.expense = expense;
        this.user = user;
        this.amountOwed = amountOwed;
    }

    public ExpenseShare() {

    }


}
