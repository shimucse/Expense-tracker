package com.project.expensetracker.service;

import com.project.expensetracker.entity.Expense;

import java.util.List;

public interface ExpenseService {
    Expense saveExpense(Expense expense);
    List<Expense> getAllExpenses();
    Expense getExpensById(int id);
    void removeExpenseById(int id );
}
