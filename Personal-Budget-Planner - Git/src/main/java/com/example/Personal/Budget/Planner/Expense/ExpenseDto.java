package com.example.Personal.Budget.Planner.Expense;

import java.time.LocalDate;


import lombok.Data;

@Data
public class ExpenseDto {
	private Long expenseId; 
	private Long userId;
	private	Long amount;
	private LocalDate date;
	private String category;
}
