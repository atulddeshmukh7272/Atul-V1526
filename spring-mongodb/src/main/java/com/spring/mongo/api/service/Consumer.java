package com.spring.mongo.api.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class Consumer {
	
		@KafkaListener(topics = "Topic",groupId="virtuoso_group")
		public void listenToTopic(String receivedMessage) {
			System.out.println("the message resived id"+receivedMessage);
			
		}
}
