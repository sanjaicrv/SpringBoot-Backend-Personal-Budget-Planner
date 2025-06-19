package com.example.Personal.Budget.Planner.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Users")
public class UserController {
@Autowired
private UserService service;

@PostMapping("/post")
public String postMethod(@RequestBody UserDto dto) {
    return service.postMethod(dto);
}
@GetMapping("/get/{userId}")
public UserDto getMethod(@PathVariable Long userId) {
	return service.getMethod(userId);
}

@PutMapping("/put/{userId}")
public String putMethod(@PathVariable Long userId,@RequestBody UserDto dto) {
	return service.putMethod(userId,dto);
}

@DeleteMapping("/delete/{userId}")
public String deleteMethod(@PathVariable Long userId) {
	return service.deleteMethod(userId);
}
@DeleteMapping("/deleteAll")
public String deleteAll() {
	return service.deleteAll();
}
}
