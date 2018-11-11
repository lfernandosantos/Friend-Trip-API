package com.friendtrip.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.friendtrip.api.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByFacebookID(String facebookID);

}
