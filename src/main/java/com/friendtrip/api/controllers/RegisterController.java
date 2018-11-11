package com.friendtrip.api.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.friendtrip.api.dto.CoordinateDto;
import com.friendtrip.api.dto.TripDto;
import com.friendtrip.api.dto.UserDto;
import com.friendtrip.api.entities.User;
import com.friendtrip.api.repositories.UserRepository;
import com.friendtrip.api.responses.Response;
import com.friendtrip.api.utils.ConstantPaths;

@RestController
@RequestMapping(ConstantPaths.API.V1.URL_API_VERSION)
public class RegisterController {
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping(ConstantPaths.API.URL_REGISTER)
	public ResponseEntity<Response<UserDto>> registerUser(@Valid @RequestBody UserDto user, BindingResult result) {
		
		Response<UserDto> response = new Response<>();
		
		if( result.hasErrors()) {
			result.getAllErrors().forEach( error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		//TODO: generete automatic by database
		
		User userEntity = new User();
		
		userEntity.setFacebookID(user.getFacebookID());
		userEntity.setName(user.getName());
		System.out.println(userEntity.toString());
		
		userRepository.save(userEntity);
		
		return ResponseEntity.ok(response);
	}
	
	@PostMapping(ConstantPaths.API.URL_CREATE_TRIP)
	public ResponseEntity<Response<TripDto>> createTrip(@Valid @RequestBody TripDto trip, BindingResult result) {
		
		Response<TripDto> response = new Response<>();
		if( result.hasErrors()) {
			result.getAllErrors().forEach( error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		trip.setId(1L);
		response.setData(trip);
		
		return ResponseEntity.ok(response);
	}
	
	@PatchMapping(ConstantPaths.API.URL_GET_TRIPS_COORDINATORS)
	public ResponseEntity<Response<List<TripDto>>> getTripsForLatLon(@Valid @RequestBody CoordinateDto coordinateDto, BindingResult result) {
		
		Response<List<TripDto>> response = new Response<>();
		if(result.hasErrors()) {
			result.getAllErrors().forEach( error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		TripDto trip = new TripDto();
		TripDto trip2 = new TripDto();
		
		trip.setName("Festa Niver");
		trip2.setName("Corrida na praia");
		
		List<TripDto> trips = new ArrayList<TripDto>();
		trips.add(trip);
		trips.add(trip2);
		
		response.setData(trips);
		return ResponseEntity.ok(response);
	}

}
