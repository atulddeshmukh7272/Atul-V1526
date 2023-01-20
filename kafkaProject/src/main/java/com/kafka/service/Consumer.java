package com.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
	
	@KafkaListener(topics = "kafkaTopic",groupId="virtuoso_group")
	public void listenToTopic(String receivedMessage) {

		System.out.println("message is" + receivedMessage );
		
	}

}
