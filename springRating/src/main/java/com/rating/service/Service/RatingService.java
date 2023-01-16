package com.rating.service.Service;

import java.util.List;

import com.rating.service.entity.Rating;

public interface RatingService {
	// create

	Rating create(Rating rating);

	// get all ratings

	List<Rating> getRating();

	// get all by UserId

	List<Rating> getRatingByUserI(String userId);

	// get all by hotel
	List<Rating> getRatingByHotelId(String hotelId);

}
