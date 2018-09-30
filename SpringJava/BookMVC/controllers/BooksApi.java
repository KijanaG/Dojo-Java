package com.garrett.bookMVC.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.garrett.bookMVC.models.Book;
import com.garrett.bookMVC.services.BookServices;


@RestController
public class BooksApi {
	private final BookServices bookService;
	
	public BooksApi(BookServices bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/api/books")
	public List<Book> index() {
		return bookService.allBooks();
	}
	
	@PostMapping("/api/books")
	public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String description, @RequestParam(value="language") String language, @RequestParam(value="pages") Integer numberOfPages) {
		Book book = new Book(title, description, language, numberOfPages);
		return bookService.createBook(book);
	}
	
	@GetMapping("/api/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		return book;
	}
	
//	@PutMapping("/api/books/{id}")
//	public Book update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String description, @RequestParam(value="language") String language, @RequestParam(value="pages") Integer numberOfPages) {
//		Book book = bookService.updateBook(id, title, description, language, numberOfPages);
//		return book;
//	}
	
	@DeleteMapping("/api/books/{id}")
	public void destroy(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}
	
}
