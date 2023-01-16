package com.user.service.repository;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.user.service.entities.User;

public interface UserRepository extends MongoRepository<User, String> {
	
	 User findByUserId(String userId);

}
