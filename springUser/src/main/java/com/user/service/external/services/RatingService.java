package com.user.service.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.user.service.entities.Rating;
@Service
@FeignClient(name="RATING-MICROSERVICE")
public interface RatingService {
	//get
	
	
	
	
	
	//post
	@PostMapping("/rating")
	public ResponseEntity<Rating> createRating(Rating values);
	
	
	
	
	//put
	@PutMapping("/rating/{ratingId}")
	public ResponseEntity<Rating> updateRAting(@PathVariable("ratingId") String ratingID ,Rating rating);
	
	
	//delete
	@DeleteMapping("/rating/{ratingId}")
	public void deleteRating(@PathVariable String ratingId);
	

}
