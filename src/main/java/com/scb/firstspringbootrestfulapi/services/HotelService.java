package com.scb.firstspringbootrestfulapi.services;

import java.util.List;

import com.scb.firstspringbootrestfulapi.entities.Hotel;

public interface HotelService {
	public List<Hotel> getAllBooks();

	public Hotel getBookById(int bid);

	public Hotel createBook(Hotel book, int id);

	public void updateBookById(Hotel book, int bId);

	public List<Hotel> deleteBookById(int id);
}
