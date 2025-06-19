package com.example.Personal.Budget.Planner.BudgetReport;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.Personal.Budget.Planner.Expense.ExpenseServiceImple;
import com.example.Personal.Budget.Planner.Income.IncomeEntity;
import com.example.Personal.Budget.Planner.Income.IncomeJpa;
import com.example.Personal.Budget.Planner.Income.IncomeServiceImple;
import com.example.Personal.Budget.Planner.User.UserEntity;
import com.example.Personal.Budget.Planner.User.UserJpa;

@Service
public class ReportServiceimple  implements ReportService{
	
	@Autowired
	private IncomeServiceImple service;
	
	@Autowired
	private ExpenseServiceImple expservice;
	
	@Autowired
	private ReportJpa jpa;
	@Autowired
	private UserJpa userjpa;
	
	@Autowired
	private IncomeJpa incomejpa;
	
	@Override
	public ReportDto getMethod(Long userId) {
		 Long totalIncome = service.getSumIncome(userId);
		 Long totalExpense = expservice.getAllExpense(userId);
		 Long remainingBalance = totalIncome - totalExpense;
		ReportDto dto=new ReportDto();
		dto.setReportId(userId);
		dto.setUserId(userId);
		dto.setTotalIncome(totalIncome);
		dto.setTotalExpense(totalExpense);
		dto.setRemainingBalance(remainingBalance);
		return dto;
		
	}
	@Override
	public String postMethod(Long userId) {
		try {
		Optional<UserEntity> e=userjpa.findById(userId);
		if(e.isEmpty()) {
			return "UserId not exists";
		}
		List<IncomeEntity> income=incomejpa.findByuserId(userId);
		if (income.isEmpty()) {
		    return "User " + userId + " has not provided any income source";
		}

		
		Long totalIncome = service.getSumIncome(userId);
		 Long totalExpense = expservice.getAllExpense(userId);
		 Long remainingBalance = totalIncome - totalExpense;
		 Optional<ReportEntity> e1=jpa.findById(userId);
			if(e1.isPresent())
			{
				return "Already exits";
			}
		ReportEntity en=new ReportEntity();
		
		en.setReportId(userId);
		en.setUser(e.get());
		en.setTotalIncome(totalIncome);
		en.setTotalExpense(totalExpense);
		en.setRemainingBalance(remainingBalance);
		jpa.save(en);
		return "Success";
		}catch(Exception e) {
			e.fillInStackTrace();
			System.err.print("One user as only one report id");
			return "One user as only one report id";
		}
	}

}  