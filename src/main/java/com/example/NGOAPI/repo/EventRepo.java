package com.example.NGOAPI.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NGOAPI.model.Event;

@Repository
public interface EventRepo extends JpaRepository<Event,Long>{

}
