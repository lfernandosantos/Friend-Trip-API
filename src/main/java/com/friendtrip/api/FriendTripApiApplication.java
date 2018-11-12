package com.friendtrip.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.friendtrip.api.entities.User;
import com.friendtrip.api.repositories.UserRepository;

@SpringBootApplication
public class FriendTripApiApplication {
	
	@Autowired
	private UserRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(FriendTripApiApplication.class, args);
	}

}
