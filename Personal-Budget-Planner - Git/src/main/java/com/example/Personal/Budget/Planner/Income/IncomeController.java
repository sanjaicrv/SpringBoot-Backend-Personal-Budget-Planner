package com.example.Personal.Budget.Planner.Income;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
@CrossOrigin(origins = "*")
@RequestMapping("/Income")
public class IncomeController {
	@Autowired
	private IncomeService service;
	
	@PostMapping("/post")
	public String postMethod(@RequestBody IncomeDto dto) {
		return service.postMethod(dto);
		
	}
	@GetMapping("/get/{UserId}")
	public IncomeDto getMethod(@PathVariable Long UserId) {
		return service.getMethod(UserId);
	}
	@PutMapping("/put/{UserId}")
	public String putMethod(@PathVariable Long UserId,@RequestBody IncomeDto dto) {
		return service.putMethod(UserId,dto);
	}
	@DeleteMapping("/delete/{UserId}")
	public String deleteMethod(@PathVariable Long UserId) {
		return service.deleteMethod(UserId);
	}
	@GetMapping("/getSumIncome/{userId}")
	public Long getSumIncome(@PathVariable Long userId){
		return service.getSumIncome(userId);
	}
	@GetMapping("/page")
	public Page<IncomeEntity> pagination(int pageno,int pagesize,String source){
		return service.pagination(pageno,source,pagesize);
	}
}
