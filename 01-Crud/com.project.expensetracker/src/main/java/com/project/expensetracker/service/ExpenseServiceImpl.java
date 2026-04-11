package com.project.expensetracker.service;

import com.project.expensetracker.dao.ExpenseDAO;
import com.project.expensetracker.entity.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    private ExpenseDAO expenseDAO;
    @Autowired
    public ExpenseServiceImpl(ExpenseDAO expenseDAO){
        this.expenseDAO = expenseDAO;
    }
    @Override
    public Expense saveExpense(Expense expense) {
          expenseDAO.saveExpense(expense);
        return expense;
    }

    @Override
    public List<Expense> getAllExpenses() {
         List<Expense> list = expenseDAO.getAllExpenses();
         return list;
    }

    @Override
    public Expense getExpensById(int id) {
        return expenseDAO.getExpensById(id);
    }



    @Override
    public void removeExpenseById(int id) {
         expenseDAO.removeExpenseById(id);
    }
}
