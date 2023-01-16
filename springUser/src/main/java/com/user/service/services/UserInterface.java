package com.user.service.services;

import java.util.List;

import com.user.service.entities.User;

public interface UserInterface {
	// user operation

	// create user
	User saveUser(User user);

	// get AllUser
	List<User> getAllUser();

	// get single user of given userId
	User getUser(String userId);
	
	// User findByUSerId();
	User getByUserId(String userId);

	
	//delete
	//update
}
