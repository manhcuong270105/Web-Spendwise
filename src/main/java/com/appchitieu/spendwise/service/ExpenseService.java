package com.appchitieu.spendwise.service;

import com.appchitieu.spendwise.model.Expense;
import com.appchitieu.spendwise.model.User;
import com.appchitieu.spendwise.repository.ExpenseRepository;
import com.appchitieu.spendwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Expense> getExpensesByUserId(Long userId) {
        return expenseRepository.findByUserId(userId);
    }

    public Expense createExpense(Expense expense, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User không tồn tại"));
        expense.setUser(user);
        return expenseRepository.save(expense);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}