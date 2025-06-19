package com.example.Personal.Budget.Planner.Expense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseJpa extends JpaRepository<ExpenseEntity,Long> {
	@Query("SELECT COALESCE(SUM(i.amount), 0) FROM ExpenseEntity i WHERE i.user.userId = :userId")
	public Long getSum1(@Param("userId") Long userId);
}
