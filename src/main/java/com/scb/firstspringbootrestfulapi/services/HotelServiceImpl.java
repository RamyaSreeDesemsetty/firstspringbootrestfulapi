package com.scb.firstspringbootrestfulapi.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.scb.firstspringbootrestfulapi.entities.Hotel;

@Service
public class HotelServiceImpl {
	private static List<Hotel> hotelList = new ArrayList<Hotel>();

	static {
		hotelList.add(new Hotel(1, "HyderabadHotel", "Hyderabad"));
		hotelList.add(new Hotel(2, "AndhraHotel", "Andhraparadesh"));
		hotelList.add(new Hotel(3, "ChennaiHotel", "chennai"));
	}

	// Get all hotels
	public List<Hotel> getAllHotels() {
		return hotelList;
	}

	// Get hotel by id
	public Hotel getHotelById(int hid) {

		Hotel h = null;
		try {
			h = hotelList.stream().filter(hk -> hk.getHotelId() == hid).findFirst().get();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return h;
	}

// create Hotel
	public Hotel createHotel(Hotel book) {
		hotelList.add(book);
		return book;
	}

//update Hotel
	public void updateBookById(Hotel hotel, int hId) {

		hotelList = hotelList.stream().map(h -> {
			if (h.getHotelId() == hId) {
				h.setHotelName(hotel.getHotelName());
				h.setLocation(hotel.getLocation());
			}
			return h;
		}).collect(Collectors.toList());
	}

//delete book
	public List<Hotel> deleteBookById(int id) {
		Iterator<Hotel> iterator = hotelList.iterator();
		while (iterator.hasNext()) {
			Hotel hotel = iterator.next();
			if (hotel.getHotelId() == id) {
				iterator.remove();
				break; // Assuming each book has a unique ID, we can exit the loop once we find and
						// delete the book
			}
		}
		return hotelList; // Returns the updated list of books
	}

}
