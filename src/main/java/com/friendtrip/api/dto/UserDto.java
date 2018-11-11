package com.friendtrip.api.dto;

import javax.validation.constraints.NotEmpty;

public class UserDto {

	private Long id;
	private String facebookID;
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotEmpty
	public String getFacebookID() {
		return facebookID;
	}
	public void setFacebookID(String facebookID) {
		this.facebookID = facebookID;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
