package com.friendtrip.api.dto;

import java.util.List;

public class TripDto {
	
	private Long id;
	private String name;
	private String latitude;
	private String longitude;
	private String date;
	private String description;
	private String status;
	private Long idCreator;
	private List<Long> followers;
	//private List<String> tags;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getIdCreator() {
		return idCreator;
	}
	public void setIdCreator(Long idCreator) {
		this.idCreator = idCreator;
	}
	public List<Long> getFollowers() {
		return followers;
	}
	public void setFollowers(List<Long> followers) {
		this.followers = followers;
	}

}
