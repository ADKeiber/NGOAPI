package com.example.NGOAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@Entity 
@ApiModel(description="All details about a specific role")
public class Role {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	 	@ApiModelProperty(notes = "The database generated event ID")
	    private Long id;
	 	@ApiModelProperty(notes = "The name of the role used for permissions")
	    private String name;

	    public Role() {
	    }

	    public Role(String name) {
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
	        return "Role{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                '}';
	    }
}
