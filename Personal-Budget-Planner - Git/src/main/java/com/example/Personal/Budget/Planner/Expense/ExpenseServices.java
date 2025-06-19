package com.example.Personal.Budget.Planner.Expense;


public interface ExpenseServices {

	String postMethod(ExpenseDto dto);

	ExpenseDto getMethod(Long userId);

	String updateMethod(Long userId, ExpenseDto dto);

	String deleteMethod(Long userId);

	Long getAllExpense(Long userId);


}
