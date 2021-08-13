package com.example.NGOAPI.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.NGOAPI.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

	@Query("SELECT u FROM User u WHERE u.email = :email")
	User findUserByEmail(@Param("email")String email);
}
