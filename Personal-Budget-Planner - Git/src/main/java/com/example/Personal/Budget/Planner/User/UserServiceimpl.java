package com.example.Personal.Budget.Planner.User;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Personal.Budget.Planner.Gmail.GmailServiceimpl;

@Service
public class UserServiceimpl implements UserService {
	@Autowired
	private UserJpa jpa;
	
	@Autowired
	private GmailServiceimpl gimpl;
	@Override
	public String postMethod(UserDto dto) {
		try {
		UserEntity entity = new UserEntity();
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		entity.setCreatedAt(dto.getCreatedAt());
		entity.setUpdatedAt(dto.getUpdatedAt());
		jpa.save(entity);
		String name=gimpl.sendGmail(dto.getEmail());
		return name + " sended Mail successfully and stored in DB";
		//return "Posted successfully";
		}catch(Exception e) {
			return "Error";
		}
		
	}

	@Override
	public UserDto getMethod(Long userId) {
		Optional<UserEntity> e=jpa.findById(userId);
		if(e.isPresent()) {
			UserEntity ent=e.get();
			UserDto dto=new UserDto();
			dto.setUserId(userId);
			dto.setName(ent.getName());
			dto.setEmail(ent.getEmail());
			dto.setCreatedAt(ent.getCreatedAt());
			dto.setUpdatedAt(ent.getUpdatedAt());
			return dto;
		}else {
			throw new RuntimeException("Not found");
		}
	}

	@Override
	public String putMethod(Long userId, UserDto dto) {
		Optional<UserEntity> e=jpa.findById(userId);
		UserEntity ent=e.get();
		ent.setName(dto.getName());
		ent.setEmail(dto.getEmail());
		ent.setPassword(dto.getPassword());
		ent.setCreatedAt(dto.getCreatedAt());
		ent.setUpdatedAt(dto.getUpdatedAt());
		jpa.save(ent);
		return "updated";
	}

	@Override
	public String deleteMethod(Long userId) {
		if(jpa.existsById(userId)) {
			jpa.deleteById(userId);
			return "deleted";
		}else {
			return "data not found";
		}
	}

	@Override
	public String deleteAll() {
		jpa.deleteAll();
		return "delete table";
	}

}
