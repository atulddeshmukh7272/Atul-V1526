package com.user.service.services;








import java.util.Arrays;
//import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.entities.Hotel;
import com.user.service.entities.Rating;
import com.user.service.entities.User;
import com.user.service.exception.UserException;
import com.user.service.external.services.HotelService;
import com.user.service.repository.UserRepository;




@SuppressWarnings("unchecked")
@Service
public class UserServiceImpl implements UserInterface {

	@Autowired
	UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private HotelService hotelService;
	
	//logger concept

	//private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	private static final Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
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
		//get user from database with the help of user repository
		User obj= userRepository.findByUserId(userId);
		if(obj!=null) {
		//fetch rating of the  above user from rating service
		//http://localhost:9595/rating/users/122
		//ArrayList<Rating> 
		Rating[] ratingOfUser = restTemplate.getForObject("http://RATING-MICROSERVICE/rating/users/"+obj.getUserId(),Rating[].class );
		logger.info("{}",ratingOfUser);
		// Arrays.stream(ratingOfUser).toList();
		 //  Stream<String> stream = Arrays.stream(arr);
		List<Rating> ratings = Arrays.stream(ratingOfUser).toList();
		
		
		List<Rating> ratingList = ratings.stream().map(rating ->{
			//api call to hotel service to get the hotel
			//http://localhost:9090/hotels/2
			//ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-MICROSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
					//forEntity.getBody();
			//logger.info("response status code:{}", forEntity.getStatusCode());
			//set the hotel to reating
			rating.setHotel(hotel);
			//return the rating
			return rating;	
		}).collect(Collectors.toList());
		obj.setRatings(ratingList);
		
		
		//System.out.println(obj);
		//System.out.println(forObject);
		return obj;
		}
		
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
