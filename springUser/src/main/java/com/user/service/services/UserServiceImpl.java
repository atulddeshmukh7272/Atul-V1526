package com.user.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.entities.User;
import com.user.service.exception.UserException;
import com.user.service.repository.UserRepository;
@Service
public class UserServiceImpl  implements UserInterface{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	

	@Override
	public User getByUserId(String userId) {
		User obj= userRepository.findByUserId(userId);
		if(obj!=null)
			return obj;
		else
			throw new UserException("user with given id is not found on server!!"+userId);
		
		//return userRepository.findByUserId(userId)
				//.orElseThrow(() -> new UserException("user with given id is not found on server!!"+userId));
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
