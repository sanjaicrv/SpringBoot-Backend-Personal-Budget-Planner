package com.example.Personal.Budget.Planner.Income;



import org.springframework.data.domain.Page;

public interface IncomeService {

	String postMethod(IncomeDto dto);

	IncomeDto getMethod(Long userId);

	String putMethod(Long userId, IncomeDto dto);

	String deleteMethod(Long userId);

	Long getSumIncome(Long userId);

	Page<IncomeEntity> pagination(int pageno, String source, int pagesize);

}
