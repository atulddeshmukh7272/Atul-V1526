package com.spring.mongo.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.mongo.api.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer> {

	//boolean deleteById(int id);
	
	//Book findByIdAndIsActiveTrue(Integer id);
	
	Book findByIdAndIsActiveTrue(Integer id);
	
	List<Book> findAllByBookNameAndIsActiveTrue(String bookName);
	
	
	public List<Book> findAllByIsActiveTrue();
	
	public List<Book> findAllByAuthorAndIsActiveTrue(String authorName);
	
	
	public boolean deleteBookById(Integer id);
	
	//public List<Book> findByAuthorAndIsActiveTrue(String authorName);
	//List<Book> findAllByAuthorNameAndIsActiveTrue(String authorName);
	//public List<Book> findAllByBookNameAndIsActiveTrue(String bookName);
	

}
	