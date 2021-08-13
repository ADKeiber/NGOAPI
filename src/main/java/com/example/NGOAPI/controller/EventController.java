package com.example.NGOAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
}
