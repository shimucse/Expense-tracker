package com.project.expensetracker.dao;

import com.project.expensetracker.entity.Expense;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExpenseDAOImpl implements ExpenseDAO {
    private final EntityManager entityManager;
    @Autowired
    public ExpenseDAOImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }
    @Transactional
    @Override
    public void saveExpense(Expense expense) {
            entityManager.merge(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        TypedQuery<Expense> theQuery = entityManager.createQuery("from Expense", Expense.class);
        //execute query and get result list
        List<Expense> results = theQuery.getResultList();
        return results;
    }
    @Override
    public Expense getExpensById(int id) {
        Expense expense = entityManager.find(Expense.class, id);
        return expense;
    }

    @Transactional
    @Override
    public void removeExpenseById(int id) {
        Expense expense = entityManager.find(Expense.class, id);
        if(expense!=null){
            entityManager.remove(expense);
        }
        else throw new RuntimeException();
    }
    @Override
    public Double getTotalExpense() {
        return entityManager.createQuery(
                "SELECT SUM(e.amount) FROM Expense e", Double.class
        ).getSingleResult();
    }

}
