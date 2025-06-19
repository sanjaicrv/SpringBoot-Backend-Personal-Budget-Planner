package com.example.Personal.Budget.Planner.BudgetReport;

import lombok.Data;

@Data
public class ReportDto {
	private Long reportId;
	private Long userId;
	private Long totalIncome;
	private Long totalExpense;
	private Long remainingBalance;
}
