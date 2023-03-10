package com.spring.mongo.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongo.api.exception.BookException;
import com.spring.mongo.api.model.Book;
import com.spring.mongo.api.service.BookServiceImpl;
import com.spring.mongo.api.service.SequenceGeneratorService;

import jakarta.validation.Valid;

@RestController
public class BookController {

	@Autowired
	BookServiceImpl bookService;
	
	@Autowired
	SequenceGeneratorService generatorService;

	@PostMapping("/book")
	public String saveBook( @Valid @RequestBody Book book) {
	book.setId(generatorService.getSequenceNumber(Book.SEQUENCE_NAME));   //go into database and check last id and set here
		book.setActive(true);
	if( bookService.save(book)){
		return "Book Data Save Succesfully";
	}else
		return "Somthing went wrong!!!";

	}
	@GetMapping("/book")
	public Book getBook(@RequestParam("id") Integer id) {
			return bookService.findById(id);
	}

	@DeleteMapping("/book/{id}")
	public String deleteBook(@PathVariable int id) {
		if (bookService.deleteId(id)) {
			return "deleted";
		} else {
			  throw new BookException("data not present");
		}
	}

	@PutMapping("/book/{id}")
	public String updataBook(@PathVariable("id") int id, @RequestBody Book book) {
		if (bookService.updateBook(id, book))
			return "data updated";
		else
			return "not updated";

	}

	@GetMapping("/getBookByName")
	public List<Book> getBookByName(@RequestParam("bookName") String bookName) {
		
		List<Book> list=bookService.findByBookName(bookName);
			if(!list.isEmpty())
				return list;
			else
				throw new BookException(" BookName Not present");
	}


	@GetMapping("/getBookByAuthor")
	public List<Book> getBookByAuthor(@RequestParam("authorName") String authorName) {
		System.out.println(authorName);
		return bookService.findByAuthorName(authorName);
	}
	
	
	
	@GetMapping("/books")
		public List<Book> getAllBook(){	
		return bookService.findAllBook();
		
	}

	@DeleteMapping("/delt/{id}")  //soft delete
	public String deleteBookById(@PathVariable int id) {
		if(bookService.deleteBookById(id))
			return "data deleted";
		else
			return "data not deleted";
	}
	
	

}