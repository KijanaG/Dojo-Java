package com.garrett.bookMVC.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.garrett.bookMVC.models.Book;
import com.garrett.bookMVC.repositories.BookRepository;

@Service
public class BookServices {
	private final BookRepository bookRepository;
	
	public BookServices(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public List<Book> allBooks(){
		return bookRepository.findAll();
	}
	
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}
	
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	
	public void updateBook(Book book) {
		bookRepository.save(book);
		book.setUpdatedAt(new Date());
	}

}
