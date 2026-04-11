package com.project.expensetracker.dao;

import com.project.expensetracker.entity.Expense;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseDAO {
    void saveExpense(Expense expense);
    List<Expense> getAllExpenses();
    Expense getExpensById(int id);
    void removeExpenseById(int id );


}
