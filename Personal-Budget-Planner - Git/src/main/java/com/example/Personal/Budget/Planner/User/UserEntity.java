package com.example.Personal.Budget.Planner.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.Personal.Budget.Planner.BudgetReport.ReportEntity;
import com.example.Personal.Budget.Planner.Expense.ExpenseEntity;
import com.example.Personal.Budget.Planner.Income.IncomeEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="user")
@Data
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="UserId")
    private Long userId;
	
	@Column(name="username")
    private String name;
	
	@Column(name="email")
    private String email;
	
	@Column(name="password")
    private String password;
	
	@Column(name="CreatedAt")
    private LocalDateTime createdAt;
	
	@Column(name="UpdatedAt")
    private LocalDateTime updatedAt;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<IncomeEntity> income=new ArrayList<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<ExpenseEntity> expenses = new ArrayList<>();
	
	@OneToOne(mappedBy="user",cascade = CascadeType.ALL)
	private ReportEntity report;


}
