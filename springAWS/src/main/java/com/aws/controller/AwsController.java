package com.aws.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AwsController {
	
	@GetMapping("/rest")
	public String home() {
		return "AWS first deployment...";
		
	}

}
