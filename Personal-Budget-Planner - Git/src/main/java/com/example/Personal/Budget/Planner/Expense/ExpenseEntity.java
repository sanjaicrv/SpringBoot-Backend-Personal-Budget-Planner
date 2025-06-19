package com.example.Personal.Budget.Planner.Expense;

import java.time.LocalDate;

import com.example.Personal.Budget.Planner.User.UserEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Expense")
@Data
public class ExpenseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ExpenseId")
	private Long expenseId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="UserId")
	private UserEntity user;
	
	@Column(name="Amount")
	private Long amount;
	
	@Column(name="Date")
	private LocalDate date;
	
	@Column(name="Category")
	private String category;
	
}
