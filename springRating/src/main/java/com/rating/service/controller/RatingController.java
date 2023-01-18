package com.rating.service.controller;

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

import com.rating.service.Service.RatingService;
import com.rating.service.entity.Rating;

@RestController
@RequestMapping("/rating")
public class RatingController {
	@Autowired
	RatingService ratingService;

	// create rating
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating) {

		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));

	}
	//getAll
	@GetMapping
	public ResponseEntity<List<Rating>> getRating(){
		return ResponseEntity.ok(ratingService.getRating());
	}
	
	//
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId( @PathVariable String userId){
		return ResponseEntity.ok(ratingService.getRatingByUserI(userId));
	}
	//
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable  String hotelId){
		return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<Rating>> getRatingAll(){
		return ResponseEntity.ok(ratingService.getAll());
	}

}
