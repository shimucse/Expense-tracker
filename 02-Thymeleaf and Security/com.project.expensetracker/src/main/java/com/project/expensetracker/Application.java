package com.project.expensetracker;

import com.project.expensetracker.dao.ExpenseDAO;
import com.project.expensetracker.entity.Expense;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}
	@Bean
	CommandLineRunner run(ExpenseDAO expenseDAO){
		return args -> {
			//System.out.println("hello world");
            //createNewExpense (expenseDAO);
			//printAllExpense(expenseDAO);
		};
	}

	private void printAllExpense(ExpenseDAO expenseDAO) {
		List<Expense> allExpenses = expenseDAO.getAllExpenses();

		// Print each expense using a for-each loop
		System.out.println("All Expenses:");
		for (Expense exp : allExpenses) {
			System.out.println("ID: " + exp.getId() +
					", Title: " + exp.getTitle() +
					", Amount: " + exp.getAmount() +
					", Category: " + exp.getCategory() +
					", Date: " + exp.getExpenseDate() +
					", Created At: " + exp.getCreatedAt());
		}
	}

	private void createNewExpense(ExpenseDAO expenseDAO) {
		 Expense theExpense = new Expense("Lunch",12.50,"Food", LocalDate.of(2026,4,9), LocalDateTime.now()) ;
		 expenseDAO.saveExpense(theExpense);


	}

}
