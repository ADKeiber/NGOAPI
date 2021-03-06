package com.example.NGOAPI.model;

import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import javax.persistence.UniqueConstraint;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@ApiModel(description="All details about a specific user")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "The database generated user ID")
    private Long id;

	@ApiModelProperty(notes = "User's first name")
    private String firstName;
	
	@ApiModelProperty(notes = "User's last name")
    private String lastName;
	
	@ApiModelProperty(notes = "User's email used for login")
    private String email;
	
	@ApiModelProperty(notes = "User's password used for login")
    private String password;

	@ApiModelProperty(notes = "The User's roles and permissions")
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

	@ApiModelProperty(notes = "Event's that the user signed up for")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_events",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    private Set<Event> registeredEvents;
    
	@ApiModelProperty(notes = "The database generated event ID")
    public Set<Event> getRegisteredEvents() {
		return registeredEvents;
	}

	public void setRegisteredEvents(Set<Event> registeredEvents) {
		this.registeredEvents = registeredEvents;
	}

	public User() {
    }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public User(String firstName, String lastName, String email, String password, Collection<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
  
    public boolean hasRole(String role) {
    	boolean hasRole = false;
    	for(Role r: this.roles) {
    		if(r.getName().equals(role)) {
    			hasRole=true;
    		}
    	}
    	return hasRole;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	@Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + "*********" + '\'' +
                ", roles=" + roles +
                '}';
    }
}
