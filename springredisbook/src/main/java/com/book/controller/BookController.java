package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.model.Book;
import com.book.repository.BookRepository;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;

	@PostMapping
	public Book save(@RequestBody Book book) {

		return bookRepository.save(book);

	}
	@GetMapping
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	@GetMapping("/{id}")
	public Book findProduct(@PathVariable int id) {
		return bookRepository.findProductById(id);
	}
	@DeleteMapping("/{id}")
	public String deletebooks(@PathVariable int id) {
		return bookRepository.deleteBook(id);
	}
}
