package com.scb.firstspringbootrestfulapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scb.firstspringbootrestfulapi.entities.Hotel;
import com.scb.firstspringbootrestfulapi.services.HotelServiceImpl;


@RestController
@Controller
@RequestMapping("/hotels")
public class HotelController {
	@Autowired
	HotelServiceImpl hotelServiceImpl;

	// Get5 method
	public ResponseEntity<List<Hotel>> getHotelData()

	{
		List<Hotel> hoteldata = hotelServiceImpl.getAllHotels();

		if (hoteldata.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		} else {
			return ResponseEntity.of(Optional.of(hoteldata));
		}
	}

	@GetMapping("/hotelall")
		  public List<Hotel> gethotels()
	        {
				List<Hotel> hoteldata = hotelServiceImpl.getAllHotels();
	        	       
	        	      return hoteldata;
					}

	@GetMapping("/hotelbyid/{id}")
	public ResponseEntity<Hotel> getBookById(@PathVariable("id") int id) {
		Hotel hotel = hotelServiceImpl.getHotelById(id);
		if (hotel == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			// return ResponseEntity.badRequest().body("Given book id doesn't exist in
			// database");
		} else {
			return ResponseEntity.of(Optional.of(hotel));
			// return ResponseEntity.of(Optional.empty());

		}
	}

	// Adding book in booklist
	@PostMapping("/addonebook")
	public ResponseEntity<Hotel> addBook(@RequestBody Hotel hotel) {
		Hotel hkk = null;
		try {
			hkk = hotelServiceImpl.createHotel(hotel);
			return ResponseEntity.created(null).body(hkk);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@PutMapping("/hotel/{hotelid}")
	public Hotel updateBook(@RequestBody Hotel hotel, @PathVariable("hotelid") int id) {
		hotelServiceImpl.updateBookById(hotel, id);
		System.out.println("update list:->" + hotel);
		return hotel;

	}

	// delete book from list
	@DeleteMapping("/hotel/{hotelid}")
		  public List<Hotel> deleteBook(@PathVariable("hotelid") int id)
		  {
			          List<Hotel> hlist = hotelServiceImpl.deleteBookById(id);
			          return(hlist);
		  }
}
