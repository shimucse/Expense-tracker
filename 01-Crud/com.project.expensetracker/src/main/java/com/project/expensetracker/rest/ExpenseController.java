package com.project.expensetracker.rest;


import com.project.expensetracker.entity.Expense;
import com.project.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping()
    public List<Expense> findAll() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/{id}")
    public Expense findById(@PathVariable int id) {
        return expenseService.getExpensById(id);
    }

    @PostMapping("/save")
    public Expense saveExpense(@RequestBody Expense expense) {

        if (expense.getCreatedAt() == null) {
            expense.setCreatedAt(LocalDateTime.now());
        }

        return expenseService.saveExpense(expense);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteExpense(@PathVariable int id) {
        expenseService.removeExpenseById(id);
    }
    @PutMapping("/update/{id}")
    public Expense updateExpense(@PathVariable int id, @RequestBody Expense expense){

        Expense existing = expenseService.getExpensById(id);

        if (existing == null) {
            throw new RuntimeException("Expense not found");
        }
        existing.setTitle(expense.getTitle());
        existing.setAmount(expense.getAmount());
        existing.setCategory(expense.getCategory());
        existing.setExpenseDate(expense.getExpenseDate());

        return expenseService.saveExpense(existing);
    }
    @PatchMapping("/PartialUpdate/{id}")
    public Expense partialUpdate(@PathVariable int id, @RequestBody Expense expense){
            Expense existing = expenseService.getExpensById(id);
            if(expense.getTitle() !=null){
                existing.setTitle(expense.getTitle());
            }
            if(expense.getAmount()!=null){
                existing.setAmount(expense.getAmount());
            }
            if(expense.getCategory() !=null){
                existing.setCategory(expense.getCategory());
            }
            if(expense.getExpenseDate()!=null){
                existing.setExpenseDate(expense.getExpenseDate());
            }
            return expenseService.saveExpense(existing);
    }

}
