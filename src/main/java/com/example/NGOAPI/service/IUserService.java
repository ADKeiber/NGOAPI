package com.example.NGOAPI.service;

import com.example.NGOAPI.model.User;

public interface IUserService {
	public User findUserByEmail(String username);
	public void deleteUserByEmail(String email);
	public void updateUser(long id, User u);
	public void createuser(User u);
}
