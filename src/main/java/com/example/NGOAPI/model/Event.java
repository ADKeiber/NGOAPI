package com.example.NGOAPI.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="Events")
@ApiModel(description="All details about a specific event")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The database generated event ID")
	private long id;
	
	@ApiModelProperty(notes = "The name of the event")
	private String name;
	
	@ApiModelProperty(notes = "Categories that an event fits into")
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "event_categories",
            joinColumns = @JoinColumn(
                    name = "event_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "category_id", referencedColumnName = "id"))
	private Set<EventCategory> category;
	
	@ApiModelProperty(notes = "Location where event takes place")
	private String location;
	
	@ApiModelProperty(notes = "Event's start date and time")
	private Date start;
	
	@ApiModelProperty(notes = "Event's end date and time")
	private Date end;
	
	@ApiModelProperty(notes = "Cost for an adult ticket to event")
	private double adultCost;
	
	@ApiModelProperty(notes = "Cost for a child ticket to event")
	private double childCost;
	
	@ApiModelProperty(notes = "URL of event image")
	private String image;
	
	@ApiModelProperty(notes = "boolean dedicated to a user's ability to register for event")
	private boolean canRegister;
	
	@ApiModelProperty(notes = "Event's max capacity")
	private int maxCapacity;
	
	@ApiModelProperty(notes = "Current amount of attendees ")
	private int currentPeople;
	
	@ApiModelProperty(notes = "The attendees who already signed up for event")
	@ManyToMany(cascade=CascadeType.ALL, mappedBy = "registeredEvents", fetch = FetchType.LAZY)
	private Set<User> attendees; 
	
	public Event(){
		
	}

	public Event(String name, String location, Date start, Date end, double adultCost,
			double childCost, String image, boolean canRegister, int maxCapacity, int currentPeople,
			Set<User> attendees) {
		super();
		this.name = name;
//		this.category = category;
		this.location = location;
		this.start = start;
		this.end = end;
		this.adultCost = adultCost;
		this.childCost = childCost;
		this.image = image;
		this.canRegister = canRegister;
		this.maxCapacity = maxCapacity;
		this.currentPeople = currentPeople;
		this.attendees = attendees;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public EventCategory getCategory() {
//		return category;
//	}
//
//	public void setCategory(EventCategory category) {
//		this.category = category;
//	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public double getAdultCost() {
		return adultCost;
	}

	public void setAdultCost(double adultCost) {
		this.adultCost = adultCost;
	}

	public double getChildCost() {
		return childCost;
	}

	public void setChildCost(double childCost) {
		this.childCost = childCost;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isCanRegister() {
		return canRegister;
	}

	public void setCanRegister(boolean canRegister) {
		this.canRegister = canRegister;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public int getCurrentPeople() {
		return currentPeople;
	}

	public void setCurrentPeople(int currentPeople) {
		this.currentPeople = currentPeople;
	}

	public Set<User> getAttendees() {
		return attendees;
	}

	public void setAttendees(Set<User> attendees) {
		this.attendees = attendees;
	}
	
	
}
