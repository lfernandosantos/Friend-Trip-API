package com.friendtrip.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.friendtrip.api.entities.Trip;

public interface TripRepository extends JpaRepository<Trip, Long>{
	
	List<Trip> findByCreator(String creatorId);
	Trip findByName(String name);
}
