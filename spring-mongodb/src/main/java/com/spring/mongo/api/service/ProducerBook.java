//package com.spring.mongo.api.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//@Service
//public class ProducerBook {
//	@Autowired
//	KafkaTemplate<String, String> kafkaTemplate;
//	
//	public void sendMsgToTopic(String message) {
//		kafkaTemplate.send("BokkTopic",message);
//	}
//}
