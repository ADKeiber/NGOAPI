package com.example.NGOAPI.service;

import java.util.List;

import com.example.NGOAPI.model.Event;

public interface IEventService {
	public List<Event> getEvents();
	public Event getEventByName(String name);
	public Event getEventById(long id);
	public Event getEventByAvailable();
	public void editEvent(long id, Event e);
	public void addEvent(Event e);
	public void deleteEventById(long id);
}
