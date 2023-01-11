package com.spring.mongo.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.mongo.api.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer> {

	//boolean deleteById(int id);
	
	Book findByIdAndIsActiveTrue(Integer id);

	List<Book> findAllByBookNameAndIsActiveTrue(String bookName);
	
	List<Book> findAllByAuthorNameAndIsActiveTrue(String authoreName);
	
	public List<Book> findAllByIsActiveTrue();
	
	//public List<Book> findAllByBookNameAndIsActiveTrue(String bookName);
	
	

}
	