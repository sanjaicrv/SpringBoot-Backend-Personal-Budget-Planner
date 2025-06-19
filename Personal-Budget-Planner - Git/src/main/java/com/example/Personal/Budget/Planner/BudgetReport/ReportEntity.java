package com.example.Personal.Budget.Planner.BudgetReport;

import com.example.Personal.Budget.Planner.User.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="BudgetReports")
@Data
public class ReportEntity {

    @Id
    @Column(name="ReportId")
    private Long reportId; 

    @OneToOne
    @JoinColumn(name="UserId") 
    private UserEntity user;

    @Column(name="Total_Income")  
    private Long totalIncome;

    @Column(name="Total_Expense")
    private Long totalExpense;

    @Column(name="Remaining_Balance")
    private Long remainingBalance;
}
