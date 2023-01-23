package com.spring.mongo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongo.api.service.ProducerBook;




@RestController
@RequestMapping("/restbook")
public class BookKafkaController {

	
		@Autowired
		ProducerBook producerBook;
		
		@GetMapping("/{message}")
		public String getMessageFromClient(@PathVariable String message) {
			producerBook.sendMsgToTopic(message);
			return "data published";
		}
		

	}


