package com.user.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.user.service.entities.Rating;
import com.user.service.external.services.RatingService;

@SpringBootTest
class SpringUserApplicationTests {
	@Autowired
private RatingService ratingService;
//	@Test
//	void createRating() {
//		Rating rating=Rating.builder().rating(11).hotelId("").feedback("this is created using fiegn  client").build();
//		Rating saveRating = ratingService.createRating(rating);
	  
//		System.out.println("new rating created");
//		
//	
	}

}
