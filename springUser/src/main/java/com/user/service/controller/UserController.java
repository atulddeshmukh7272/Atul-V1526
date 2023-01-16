package com.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.entities.User;
import com.user.service.services.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {
	//create
	@Autowired
	private UserServiceImpl userServiceImpl;
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
	 User user1 = userServiceImpl.saveUser(user);
	 return ResponseEntity.status(HttpStatus.CREATED).body(user1);
		
	}
	
	//single user get
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String  userId){
		
		User user = userServiceImpl.getByUserId(userId);
		return ResponseEntity.ok(user);
		
	}
	
	
	//all user get
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		List<User> allUser = userServiceImpl.getAllUser();
		
		
		return ResponseEntity.ok(allUser);
		
	}

}
