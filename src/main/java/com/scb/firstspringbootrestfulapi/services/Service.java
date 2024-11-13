package com.scb.firstspringbootrestfulapi.services;

import java.util.List;

import com.scb.firstspringbootrestfulapi.entities.Book;

public interface Service {
	public List<Book> getAllBooks();

	public Book getBookById(int bid);

	public Book createBook(Book book, int id);

	public void updateBookById(Book book, int bId);

	public List<Book> deleteBookById(int id);
}
