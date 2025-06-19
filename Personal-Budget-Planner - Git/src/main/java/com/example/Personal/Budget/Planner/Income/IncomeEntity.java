package com.example.Personal.Budget.Planner.Income;

import java.time.LocalDate;

import com.example.Personal.Budget.Planner.User.UserEntity;

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
@Table(name="income")
@Data
public class IncomeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="incomeid")
	private Long incomeId;
	
	@ManyToOne
	@JoinColumn(name="userid",nullable = false)
	private UserEntity user;
	
	@Column(name="amount")
	private Long amount;
	
	@Column(name="source")
	private String source;
	
	@Column(name="date")
	private LocalDate date;
}
