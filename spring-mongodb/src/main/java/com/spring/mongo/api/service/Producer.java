package com.spring.mongo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class Producer {
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMsgToTopic(String message) {
		kafkaTemplate.send("Topic",message);

}
