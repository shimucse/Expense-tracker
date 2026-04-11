package com.project.expensetracker.Controller;

import com.project.expensetracker.entity.Expense;
import com.project.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/expenses")
public class ExpenseViewController {
      private final ExpenseService expenseService;
      @Autowired
      public ExpenseViewController(ExpenseService expenseService){
            this.expenseService = expenseService;
      }
      //Show all expense
    @GetMapping("/list")
    public String listExpenses(Model model){
        List<Expense> expenses =   expenseService.getAllExpenses();
        model.addAttribute("expenses",expenses);
        return "expenses-list";
    }
    @GetMapping("/form")
    public String showForm(Model model){
           model.addAttribute("expense", new Expense());
           return "expenses-form";
    }
    @PostMapping("/save")
    public String saveExpense(@ModelAttribute Expense expense){
          expenseService.saveExpense(expense);
          return "redirect:/expenses/list";
    }
    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable int id){
          expenseService.removeExpenseById(id);
          return "redirect:/expenses/list";
    }
    @GetMapping("/edit/{id}")
    public String editExpense(@PathVariable int id, Model model ){
          Expense expense = expenseService.getExpensById(id);
        model.addAttribute("expense",expense);
          return "expenses-form";

    }

}
