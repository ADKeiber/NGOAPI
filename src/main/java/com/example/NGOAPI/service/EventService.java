package com.example.NGOAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NGOAPI.model.Event;
import com.example.NGOAPI.repo.EventRepo;

@Service
public class EventService implements IEventService{

	@Autowired
	EventRepo repo;
	
	@Override
	public List<Event> getEvents() {
		return repo.findAll();
	}

	@Override
	public Event getEventByName(String name) {
		return repo.findEventByName(name);
	}

	@Override
	public Event getEventById(long id) {
		return repo.getById(id);
	}

	@Override
	public Event getEventByAvailable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editEvent(long id, Event e) {
		e.setId(id);
		repo.save(e);
	}

	@Override
	public void addEvent(Event e) {
		repo.save(e);	
	}

	@Override
	public void deleteEventById(long id) {
		repo.deleteById(id);
	}

}
