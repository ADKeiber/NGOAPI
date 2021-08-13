package com.example.NGOAPI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.NGOAPI.model.Event;
import com.example.NGOAPI.repo.EventRepo;

@SpringBootTest
class NgoapiApplicationTests {

	@Autowired
	EventRepo repo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void test1() {
		Event e = new Event();
		
		e.setAdultCost(1);
		e.setChildCost(2);
		
		repo.save(e);
	}
	
	@Test
	void test2() {
		Event e = new Event();
		
		e.setAdultCost(2);
		e.setChildCost(3);
		
		repo.save(e);
	}
}
