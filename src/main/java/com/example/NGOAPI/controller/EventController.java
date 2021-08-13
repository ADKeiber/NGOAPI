package com.example.NGOAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.NGOAPI.model.Event;
import com.example.NGOAPI.model.User;
import com.example.NGOAPI.service.EventService;
import com.example.NGOAPI.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/event")
@Api(value="Event Management System")
public class EventController {
	
	@Autowired
	private EventService service;
	
	@GetMapping("/")
	@ApiOperation(value = "Retrieves all events")
	public List<Event> getEvents() {
		return service.getEvents();
	} 
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Retrieves specific event with given event id")
	public Event getEventById(
			@ApiParam(value = "Event Id used to retrieve event object", required = true)
			@PathVariable(value="id")Long id) {
		return service.getEventById(id);
		
	}
	
	@GetMapping("/name/{name}")
	@ApiOperation(value = "Retrieves specific event with given event name")
	public Event getEventByName(
			@ApiParam(value = "Event named used to retrieve event object", required = true)
			@PathVariable(value="name")String name) {
		return service.getEventByName(name);
		
	}
	
	@PutMapping("/update/{id}")
	@ApiOperation(value = "Updates Event object with new Event object")
	public void editEvent(
			@ApiParam(value = "Event Id to update event object", required = true)
			@PathVariable(value="id")Long id,
			@ApiParam(value = "Updated event object", required = true)
			@RequestBody Event e) {
		service.editEvent(id, e);
	}
	
	@PostMapping("/")
	@ApiOperation(value = "Adds new Event object")
	public void addEvent(
			@ApiParam(value = "New Event Object", required = true)
			@RequestBody Event e) {
		service.addEvent(e);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deletes an Event with given ID")
	public void deleteEventById(
			@ApiParam(value = "Event Id used to delete event object", required = true)
			@PathVariable(value="id")Long id) {
		service.deleteEventById(id);
	}
}
