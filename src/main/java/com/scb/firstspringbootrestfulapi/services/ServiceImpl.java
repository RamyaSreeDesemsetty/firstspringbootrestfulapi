package com.scb.firstspringbootrestfulapi.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.scb.firstspringbootrestfulapi.entities.Book;

@Service
public class ServiceImpl {

	private static List<Book> bookList = new ArrayList<Book>();

	static {
		bookList.add(new Book(1, "One Indian Girl", "Chetan Bhagat"));
		bookList.add(new Book(2, "Panchatantra", "Vishnu Sharma"));
		bookList.add(new Book(3, "Harry Potter", "J.k.Rowling"));
	}

	// Get all books
	public List<Book> getAllBooks() {
		return bookList;
	}
	// Get book by id
	public Book getBookById(int bid) {
		
		Book b =null;
try {
	b = bookList.stream().filter(bk -> bk.getId() == bid).findFirst().get();
			
      }
      catch(Exception e)
      {
      	e.printStackTrace();
      }
return b;
}

// create book
public Book createBook(Book book) {
	bookList.add(book);
	return book;
}

//update book
public void updateBookById(Book book, int bId) {

	bookList = bookList.stream().map(b -> {
		if (b.getId() == bId) {
			b.setName(book.getName());
			b.setAuthor(book.getAuthor());
		}
		return b;
	}).collect(Collectors.toList());
	}


//delete book
	public List<Book> deleteBookById(int id) {
		Iterator<Book> iterator = bookList.iterator();
		while (iterator.hasNext()) {
			Book book = iterator.next();
			if (book.getId() == id) {
				iterator.remove();
				break; // Assuming each book has a unique ID, we can exit the loop once we find and
						// delete the book
			}
		}
		return bookList; // Returns the updated list of books
}

}

