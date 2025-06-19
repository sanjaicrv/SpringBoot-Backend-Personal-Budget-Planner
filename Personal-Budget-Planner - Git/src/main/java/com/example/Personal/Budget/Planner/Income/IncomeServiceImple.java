package com.example.Personal.Budget.Planner.Income;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.Personal.Budget.Planner.User.UserEntity;
import com.example.Personal.Budget.Planner.User.UserJpa;

@Service
public class IncomeServiceImple implements IncomeService{
	@Autowired
	private IncomeJpa jpa;
	
	@Autowired
	private UserJpa jpauser;
	
	@Override
	public String postMethod(IncomeDto dto) {
		 System.out.println("Received userId: " + dto.getUserId()); // Debugging line

		    if (dto.getUserId() == null) {
		        return "UserId cannot be null";
		    }
		Optional<UserEntity> e1=jpauser.findById(dto.getUserId());
		if(e1.isEmpty()) {
			return "No user is created";
		}
		IncomeEntity entity=new IncomeEntity();
		entity.setUser(e1.get());
		entity.setIncomeId(dto.getIncomeId());
		entity.setAmount(dto.getAmount());
		entity.setSource(dto.getSource());
		entity.setDate(dto.getDate());
		jpa.save(entity);
		return "Posted Successfull";
	}

	@Override
	public IncomeDto getMethod(Long userId) {
		Optional<IncomeEntity> e=jpa.findById(userId);
		if(e.isPresent()) {
			IncomeEntity ent=e.get();
			IncomeDto dto=new IncomeDto();
			dto.setAmount(ent.getAmount());
			dto.setSource(ent.getSource());
			dto.setDate(ent.getDate());
			return dto;
		}else {
			throw new RuntimeException("Data not exists");
		}
	}

	@Override
	public String putMethod(Long userId, IncomeDto dto) {
		Optional<IncomeEntity> e=jpa.findById(userId);
		if(e.isPresent()) {
			IncomeEntity ent=e.get();
			ent.setAmount(dto.getAmount());
			ent.setSource(dto.getSource());
			ent.setDate(dto.getDate());
			jpa.save(ent);
			return "Updated successfully";
		}else {
			return "Data not exits";
		}
	}

	@Override
	public String deleteMethod(Long userId) {
		if(jpa.existsById(userId)) {
			jpa.deleteById(userId);
			return "Deleted succesfully";
		}else {
			return "Data not found";
		}
	}

	@Override
	public Long getSumIncome(Long userId) {
		return jpa.getSum(userId);
	}

	@Override
	public Page<IncomeEntity> pagination(int pageno, String source, int pagesize) {
		 Pageable pageable = PageRequest.of(pageno, pagesize);
	     return jpa.findAllBySource(source,pageable);
	}


	

	

}
