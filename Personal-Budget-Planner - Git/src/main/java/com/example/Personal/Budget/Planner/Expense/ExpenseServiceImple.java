package com.example.Personal.Budget.Planner.Expense;


import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.Personal.Budget.Planner.User.UserEntity;
import com.example.Personal.Budget.Planner.User.UserJpa;

@Service
public class ExpenseServiceImple implements ExpenseServices{

	@Autowired
	private ExpenseJpa jpa;
	
	@Autowired
	private UserJpa jpauser;
	
	@Override
	public String postMethod(ExpenseDto dto) {
		Optional<UserEntity> e1=jpauser.findById(dto.getUserId());
		if(e1.isEmpty()) {
			return "Data user is not given";
		}
		
		ExpenseEntity entity = new ExpenseEntity();
		entity.setUser(e1.get());
		entity.setExpenseId(dto.getExpenseId());
		entity.setAmount(dto.getAmount());
		entity.setCategory(dto.getCategory());
		entity.setDate(dto.getDate());
		jpa.save(entity);
		return "created Successfully";
	}

	@Override
	public ExpenseDto getMethod(Long userId) {
		Optional<ExpenseEntity> e=jpa.findById(userId);
		if(e.isPresent()) {
			ExpenseEntity en=e.get();
			ExpenseDto dto=new ExpenseDto();
			dto.setExpenseId(en.getExpenseId());
			dto.setAmount(en.getAmount());
			dto.setCategory(en.getCategory());
			dto.setDate(en.getDate());
			return dto;
		}else {
			throw new RuntimeException("Not Found");
		}
	}

	@Override
	public String updateMethod(Long userId, ExpenseDto dto) {
		Optional<ExpenseEntity> e=jpa.findById(userId);
		if(e.isPresent()) {
			ExpenseEntity en=e.get();
			en.setAmount(dto.getAmount());
			en.setCategory(dto.getCategory());
			en.setDate(dto.getDate());
			jpa.save(en);
			return "Updated";
		}else {
			return "Data not found";
		}
	}

	@Override
	public String deleteMethod(Long userId) {
		if(jpa.existsById(userId)) {
			jpa.deleteById(userId);
			return "Deleted Successfully";
		}
		else {
			return "Not found";
		}
	}

	@Override
	public Long getAllExpense(Long userId) {
		return jpa.getSum1(userId);
	}


}
