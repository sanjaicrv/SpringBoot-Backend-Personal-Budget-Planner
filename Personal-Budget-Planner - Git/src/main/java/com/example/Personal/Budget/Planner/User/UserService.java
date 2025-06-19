package com.example.Personal.Budget.Planner.User;

public interface UserService {

	String postMethod(UserDto dto);

	UserDto getMethod(Long userId);

	String putMethod(Long userId, UserDto dto);

	String deleteMethod(Long userId);

	String deleteAll();

}
