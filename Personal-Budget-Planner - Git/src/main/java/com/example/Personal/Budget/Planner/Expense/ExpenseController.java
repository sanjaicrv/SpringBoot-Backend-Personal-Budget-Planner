package com.example.Personal.Budget.Planner.Expense;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping("/Expense")
public class ExpenseController {
	@Autowired
	private ExpenseServices service;
	
	@PostMapping("/PostData")
	public String postMethod(@RequestBody ExpenseDto dto) {
		return service.postMethod(dto);
	}
	@GetMapping("/get/{UserId}")
	public ExpenseDto getMethod(@PathVariable Long userId) {
		return service.getMethod(userId);
	}
	@PutMapping("/update/{UserId}")
	public String updateMethod(@PathVariable Long userId,@RequestBody ExpenseDto dto) {
		return service.updateMethod(userId,dto);
	}
	@DeleteMapping("/delete/{UserId}")
	public String deleteMethod(@PathVariable Long userId) {
		return service.deleteMethod(userId);
	}
	@GetMapping("/getAllExpense/{userId}")
	public Long getAllExpense(@PathVariable Long userId) {
		return service.getAllExpense(userId);
	}
	
}
