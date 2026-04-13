package com.project.expensetracker.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "expenses")
public class Expense {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "category")
    private String category;

    @Column(name = "expense_date")
    private LocalDate expenseDate;

    @Column(name = "created_at")
    private LocalDateTime createdAt;// maps to DATE


    public Expense(){

    }

    public Expense(String title, Double amount, String category, LocalDate expenseDate, LocalDateTime createdAt) {
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.expenseDate = expenseDate;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "expense{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", amount='" + amount + '\'' +
                ", category='" + category + '\'' +
                ", expenseDate=" + expenseDate +
                ", createdAt=" + createdAt +
                '}';
    }
}
