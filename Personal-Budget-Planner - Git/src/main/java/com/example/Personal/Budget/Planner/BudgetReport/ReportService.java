package com.example.Personal.Budget.Planner.BudgetReport;



public interface ReportService {

	ReportDto getMethod(Long userId);

	String postMethod(Long userId);


}
