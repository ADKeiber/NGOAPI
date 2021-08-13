package com.example.NGOAPI.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NGOAPI.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

}
