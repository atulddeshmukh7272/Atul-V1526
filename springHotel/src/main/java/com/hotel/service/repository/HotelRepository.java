package com.hotel.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hotel.service.entity.Hotel;

public interface HotelRepository extends MongoRepository<Hotel, String> {

}
