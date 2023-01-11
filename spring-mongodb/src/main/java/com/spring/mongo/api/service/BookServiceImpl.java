package com.spring.mongo.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.mongo.api.exception.BookException;
import com.spring.mongo.api.model.Book;
import com.spring.mongo.api.repository.BookRepository;

@Service
public class BookServiceImpl implements BookInterface {

	@Autowired
	BookRepository bookRepository;

//	@Override
//	public boolean deleteId(Integer id) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//  
//
	@Override
	public List<Book> findAllBook() {
		return bookRepository.findAllByIsActiveTrue();

	}

	@Override
	public boolean save(Book book) {
		Book obj = book;
		String bookName=obj.getBookName();
		System.out.print(bookName);
		
//		Book bookobj= bookRepository.findByBookName(bookName);
//		if (obj.getId() < 0) {
//			throw new BookException("Id should be grater than ZERO");
//		} 
//		else if(obj.getBookName().compareToIgnoreCase(getb)k.getBookName()) {
//			throw new BookException("This book is already exist");
//		}
//		else 
//			{
//				List<Book> check = bookRepository.findAllByBookNameAndIsActiveTrue(bookName);
//				if(check.isEmpty())
//					throw new BookException("List Error");				
//			}
			
		if (bookRepository.save(book)!=null) {
				return true;
			} else
				throw new BookException("Insert the correct data ");
		}
	

	@Override
	public Book findById(Integer id) {
		return bookRepository.findByIdAndIsActiveTrue(id);

	}

	@Override
	public boolean deleteId(Integer id) {

		if (bookRepository.existsById(id)) {
			bookRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateBook(Integer id, Book book) {

		Book obj = bookRepository.findByIdAndIsActiveTrue(id); // .findById(id).get();
		
		
		if (book.getBookName() != null)
			obj.setBookName(book.getBookName());                //if we only change one data and we dont wont to affect other data ie null...
		if(book.getAuthorName() !=null)
			obj.setAuthorName(book.getAuthorName());
		if(book.getBookPublishdate() !=null)
			obj.setBookPublishdate(book.getBookPublishdate());
		if(book.getNumberOfPagesInBook() !=0)
			obj.setNumberOfPagesInBook(book.getNumberOfPagesInBook());
		if(book.getPriceOfBook() !=0)
			obj.setPriceOfBook(book.getPriceOfBook());
//
//		obj.setAuthorName(book.getAuthorName());
//		obj.setBookName(book.getBookName());
		bookRepository.save(obj);
		return true;
	}

	@Override
	public List<Book> findByBookName(String bookName) {
		// TODO Auto-generated method stub
		return bookRepository.findAllByBookNameAndIsActiveTrue(bookName);

	}

	@Override
	public List<Book> findByauthorName(String authorName) {
		// TODO Auto-generated method stub
		return bookRepository.findAllByAuthorNameAndIsActiveTrue(authorName);

	}

	@Override
	public boolean deleteBookById(Integer id) { 
		
	Book obj = bookRepository.findByIdAndIsActiveTrue(id);     //soft delete
	System.out.println(obj);	
	if(obj!=null)
		{
			obj.setActive(false);
			bookRepository.save(obj);
			return true;
		}
		else
			return false;
	}

}
