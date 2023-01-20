package com.kafka.controller; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.service.Producer;

@RestController
@RequestMapping("/rest")
public class KafkaController {
	@Autowired
	Producer producer;
	
	@GetMapping("/{message}")
	public String getMessageFromClient(@PathVariable String message) {
		producer.sendMsgToTopic(message);
		return "data published";
	}
	

}
