package com.example.Personal.Budget.Planner.Income;

import java.time.LocalDate;

import lombok.Data;

@Data
public class IncomeDto {
	private Long incomeId;
	private Long userId;
	private String source;
	private Long amount;
	private LocalDate date;
}
