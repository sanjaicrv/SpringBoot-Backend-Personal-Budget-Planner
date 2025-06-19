package com.example.Personal.Budget.Planner.Income;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeJpa extends JpaRepository<IncomeEntity, Long>{
	@Query("SELECT COALESCE(SUM(i.amount), 0) FROM IncomeEntity i WHERE i.user.userId = :userId")
	public Long getSum(@Param("userId") Long userId);

	@Query("select e from IncomeEntity e where e.user.userId=:userId")
	public List<IncomeEntity> findByuserId(@Param("userId")Long userId);

	public Page<IncomeEntity> findAllBySource(String source, Pageable pageable);




}
