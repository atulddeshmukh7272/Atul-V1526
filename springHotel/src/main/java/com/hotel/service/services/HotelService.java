package com.hotel.service.services;

import java.util.List;

import com.hotel.service.entity.Hotel;

public interface HotelService {
	
	//create
	Hotel create (Hotel hotel);
	
	
	//getaAll
	List<Hotel> getAll();
	
	
	//getsigle
	Hotel get(String id);

}
