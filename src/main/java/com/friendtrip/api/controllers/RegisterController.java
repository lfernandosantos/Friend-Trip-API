package com.friendtrip.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.friendtrip.api.dto.CoordinateDto;
import com.friendtrip.api.dto.TripDto;
import com.friendtrip.api.dto.UserDto;
import com.friendtrip.api.entities.Trip;
import com.friendtrip.api.entities.User;
import com.friendtrip.api.repositories.RepositoryManager;
import com.friendtrip.api.repositories.TripRepository;
import com.friendtrip.api.repositories.UserRepository;
import com.friendtrip.api.responses.Response;
import com.friendtrip.api.utils.ConstantMessages;
import com.friendtrip.api.utils.ConstantPaths;

@RestController
@RequestMapping(ConstantPaths.API.V1.URL_API_VERSION)
public class RegisterController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TripRepository tripRepository;
	
	
	@PostMapping(ConstantPaths.API.URL_REGISTER)
	public ResponseEntity<Response<UserDto>> registerUser(@Valid String valid, @RequestBody UserDto user, BindingResult result) {
		
		Response<UserDto> response = new Response<>();
		if( result.hasErrors()) {
			result.getAllErrors().forEach( error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		} 
		
		//repositoryManager.saveUser(user);
		
			User isSaved = userRepository.findByFacebookID(user.getFacebookID());
			
			System.out.println(isSaved);
			if(isSaved != null) {
				response.setStatusCode(ConstantMessages.Response.StatusCode.ALREADY_REGISTERED);
				response.setMsg(ConstantMessages.Response.Message.USER_ALREADY_SAVE);
			
				return ResponseEntity.ok(response);	
			}
			
			User userEntity = new User();
			userEntity.setFacebookID(user.getFacebookID());
			userEntity.setName(user.getName());
			
			userRepository.save(userEntity);
//			
//			System.out.println("printando");
//			repositoryManager = new RepositoryManager();
//			User user2 = repositoryManager.getUser(user.getFacebookID());
//			
//			System.out.println(user);
//			
			User alreadySaved = userRepository.findByFacebookID(user.getFacebookID());
			
			User userSaved = alreadySaved;
			user.setId(userSaved.getId());
			user.setFacebookID(userSaved.getFacebookID());
			user.setName(userSaved.getName());

			response.setStatusCode(ConstantMessages.Response.StatusCode.SAVED_SUCCESSFULLY);
			response.setMsg(ConstantMessages.Response.Message.USER_SAVED_SUCCESS);
			response.setData(user);
			
			return ResponseEntity.ok(response);
	}
	
	@PostMapping(ConstantPaths.API.URL_CREATE_TRIP)
	public ResponseEntity<Response<TripDto>> createTrip(@Valid @RequestBody TripDto trip, BindingResult result) {
		
		Response<TripDto> response = new Response<>();
		if( result.hasErrors()) {
			result.getAllErrors().forEach( error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Trip tripEntity = new Trip();
		tripEntity.setName(trip.getName());
		tripEntity.setDate(trip.getDate());
		tripEntity.setDescription(trip.getDescription());
		tripEntity.setLatitude(trip.getLatitude());
		tripEntity.setLongitude(trip.getLongitude());
		tripEntity.setStatus(trip.getStatus());
		tripEntity.setCreator(trip.getCreator());
		
		//Optional<User> user = this.userRepository.findById(trip.getIdCreator());
		//tripEntity.setCreator(user.get());
		
		this.tripRepository.save(tripEntity);
		
		//Trip tripSaved = this.tripRepository.findByName(tripEntity.getName());
		
		//trip.setId(tripSaved.getId());
		response.setStatusCode(ConstantMessages.Response.StatusCode.SAVED_SUCCESSFULLY);
		response.setMsg(ConstantMessages.Response.Message.TRIP_SAVED_SUCCESS);
		//response.setData(trip);
		
		return ResponseEntity.ok(response);
	}
	
	
	@PatchMapping(ConstantPaths.API.URL_GET_TRIPS_COORDINATORS)
	public ResponseEntity<Response<List<Trip>>> getTripsForLatLon(@Valid @RequestBody CoordinateDto coordinateDto, BindingResult result) {
		
		Response<List<Trip>> response = new Response<>();
		if(result.hasErrors()) {
			result.getAllErrors().forEach( error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		List<Trip> findAll = this.tripRepository.findAll();
		
		response.setData(findAll);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = ConstantPaths.API.URL_GET_TRIPS_FOR_USER+"/{facebookid}")
	public ResponseEntity<Response<List<Trip>>> getTripsForUser(@PathVariable("facebookid") String id) {
		Response<List<Trip>> response = new Response<>();
//		if(result.hasErrors()) {
//			result.getAllErrors().forEach( error -> response.getErrors().add(error.getDefaultMessage()));
//			return ResponseEntity.badRequest().body(response);
//		}
		
		List<Trip> findAll = this.tripRepository.findByCreator(id);
		
		response.setData(findAll);
		return ResponseEntity.ok(response);
	}

}
