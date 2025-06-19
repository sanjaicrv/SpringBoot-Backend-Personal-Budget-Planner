package com.example.Personal.Budget.Planner.User;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserDto {
	private Long userId;
	private String name;
	private String email;
	private String password;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
