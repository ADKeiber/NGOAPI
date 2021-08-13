package com.example.NGOAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@Entity 
@ApiModel(description="All details about a specific event's category")
public class EventCategory {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	 	@ApiModelProperty(notes = "The database generated event ID")
	    private Long id;
	 	@ApiModelProperty(notes = "Name of the category")
	    private String name;

	    public EventCategory() {
	    }

	    public EventCategory(String name) {
	        this.name = name;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    @Override
	    public String toString() {
	        return "Category{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                '}';
	    }
}
