package com.example.NGOAPI.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.NGOAPI.model.User;
import com.example.NGOAPI.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
@Api(value="User Management System")
public class UserController {
	@Autowired
	private UserService service;
	
	@ApiOperation(value = "View an employee with a specific email", response = User.class)
	@GetMapping("/{email}")
	public User getUserByEmail(
			@ApiParam(value = "User email used to retrieve user object", required = true)
			@PathVariable(value="email")String email) {
		return service.findUserByEmail(email);
	}
	
	@PostMapping("/new")
	@ApiOperation(value = "Creates a new user")
	public void saveNewUser(
			@ApiParam(value = "New User Object", required = true)
			@RequestBody User u) {
		service.createuser(u);
	}
	
	@GetMapping("/")
	@ApiOperation(value = "View a list of all users", response = List.class)
	public List<User> getAllUsers(){
		return service.getAllUsers();
	}
	
	@PutMapping("/update/{id}")
	@ApiOperation(value = "Update a user")
	public void updateUser(
			@ApiParam(value = "User Id to update user object", required = true)
			@PathVariable(value="id")Long id,
			@ApiParam(value = "Updated user object", required = true)
			@RequestBody User u) {
		service.updateUser(id, u);
	}
	
	@DeleteMapping("/delete/{email}")
	@ApiOperation(value = "Deletes user by email address")
	public void deleteUser(
			@ApiParam(value = "User email used to delete user", required = true)
			@PathVariable(value="email")String email) {
		service.deleteUserByEmail(email);
	}
}
