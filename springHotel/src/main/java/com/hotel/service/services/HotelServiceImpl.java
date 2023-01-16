package com.hotel.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.service.entity.Hotel;
import com.hotel.service.exception.ResourceNotFoundException;
import com.hotel.service.repository.HotelRepository;
@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelRepository hotelRepository;
	

	@Override
	public Hotel create(Hotel hotel) {
		// TODO Auto-generated method stub
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

	@Override
	public Hotel get(String id) {
		// TODO Auto-generated method stub
		return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel with gven id is not found!!"));
	}

}
