package com.example.Personal.Budget.Planner.BudgetReport;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Report")
public class ReportController {
	@Autowired
	private ReportService service;
	
	@PostMapping("/PostUserReport/{userId}")
	public String postMethod(@PathVariable Long userId) {
		return service.postMethod(userId);
	}
	@GetMapping("/get/{userId}")
	public ReportDto getMethod(@PathVariable Long userId) {
		return service.getMethod(userId);
	}

	
}
