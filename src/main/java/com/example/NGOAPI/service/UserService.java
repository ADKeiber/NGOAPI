package com.example.NGOAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NGOAPI.model.User;
import com.example.NGOAPI.repo.UserRepo;

@Service
public class UserService implements IUserService{

	@Autowired
	private UserRepo repo;
	
	@Override
	public User findUserByEmail(String username) {
		return repo.findUserByEmail(username);
	}

	@Override
	public void deleteUserByEmail(String email) {
		User u = repo.findUserByEmail(email);
		repo.delete(u);
	}

	@Override
	public void updateUser(long id, User u) {
		u.setId(id);
		repo.save(u);
	}

	@Override
	public void createuser(User u) {
		repo.save(u);
	}

}
