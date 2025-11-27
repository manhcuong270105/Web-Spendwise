package com.appchitieu.spendwise.controller;

import com.appchitieu.spendwise.model.Expense;
import com.appchitieu.spendwise.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "*")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public List<Expense> getAllExpenses(@RequestParam Long userId) {
        return expenseService.getExpensesByUserId(userId);
    }

    @PostMapping
    public Expense createExpense(@RequestBody Expense expense, @RequestParam Long userId) {
        return expenseService.createExpense(expense, userId);
    }

    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return "Đã xóa ID: " + id;
    }
}