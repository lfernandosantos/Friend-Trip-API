package com.friendtrip.api.repositories;

import org.springframework.beans.factory.annotation.Autowired;

import com.friendtrip.api.dto.UserDto;
import com.friendtrip.api.entities.User;

public class RepositoryManager {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TripRepository tripRepository;
	
	public RepositoryManager() {
		// TODO Auto-generated constructor stub
		
		
	}
	
	public void saveUser(UserDto user) {
		User userEntity = new User();
		userEntity.setFacebookID(user.getFacebookID());
		userEntity.setName(user.getName());
		userRepository.save(userEntity);
	}
	
	public User getUser(String facebookID) {		
		return userRepository.findByFacebookID(facebookID);
	}
	
}
