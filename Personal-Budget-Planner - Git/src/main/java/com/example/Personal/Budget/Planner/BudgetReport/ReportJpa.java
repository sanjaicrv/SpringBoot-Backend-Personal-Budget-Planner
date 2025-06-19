package com.example.Personal.Budget.Planner.BudgetReport;

import java.util.List;

import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ReportJpa extends JpaRepository<ReportEntity, Long>{

	List<ReportEntity> findByUser_UserId(Pageable page1, Long userId);
	
	
}
