package com.scb.firstspringbootrestfulapi.entities;

public class Hotel {
	private int hotelId;
	private String hotelName;
	private String Location;

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hotel(int hotelId, String hotelNmae, String location) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelNmae;
		Location = location;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelNmae=" + hotelName + ", Location=" + Location + "]";
	}

}
