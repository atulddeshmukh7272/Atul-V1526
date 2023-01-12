package com.spring.mongo.api.service;

import java.util.List;

import com.spring.mongo.api.model.Book;

public interface BookInterface {

//	
	public List<Book> findAllBook();

	public boolean save(Book book);

	public Book findById(Integer id);

	public boolean deleteId(Integer id);

	public boolean updateBook(Integer id, Book book);

	public List<Book> findByBookName(String bookName);

	//public List<Book> getauthor(String authorName);
	
	public boolean deleteBookById(Integer id);//soft delete
	
    public List<Book> findByAuthorName(String authorName);

	//public List<Book> getAllBookInfo();

}
