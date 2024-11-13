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

import com.scb.firstspringbootrestfulapi.entities.Book;
import com.scb.firstspringbootrestfulapi.services.ServiceImpl;

@RestController
@Controller
@RequestMapping("/books")
public class BookController {
	@Autowired
	ServiceImpl bookServiceImpl;

	// Get5 method
	public ResponseEntity<List<Book>> getBookData()

	{
		List<Book> bookdata = bookServiceImpl.getAllBooks();

		if (bookdata.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		} else {
			return ResponseEntity.of(Optional.of(bookdata));
		}
	}

	@GetMapping("/bookall")
		  public List<Book> getBooks()
	        {
				List<Book> bookdata = bookServiceImpl.getAllBooks();
	        	       
	        	      return bookdata;
					}

	@GetMapping("/bookbyid/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
		Book book = bookServiceImpl.getBookById(id);
		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			// return ResponseEntity.badRequest().body("Given book id doesn't exist in
			// database");
		} else {
			return ResponseEntity.of(Optional.of(book));
			// return ResponseEntity.of(Optional.empty());

		}
	}

	// Adding book in booklist
	@PostMapping("/addonebook")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book bkk = null;
		try {
			bkk = bookServiceImpl.createBook(book);
			return ResponseEntity.created(null).body(bkk);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@PutMapping("/book/{bookid}")
	public Book updateBook(@RequestBody Book book, @PathVariable("bookid") int id) {
		bookServiceImpl.updateBookById(book, id);
		System.out.println("update list:->" + book);
		return book;

	}

	// delete book from list
	@DeleteMapping("/book/{bookid}")
		  public List<Book> deleteBook(@PathVariable("bookid") int id)
		  {
			          List<Book> dlist = bookServiceImpl.deleteBookById(id);
			          return(dlist);
		  }
		}
