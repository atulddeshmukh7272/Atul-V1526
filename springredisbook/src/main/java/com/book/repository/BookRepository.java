package com.book.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.book.model.Book;


@Repository
public class BookRepository  {
	@Autowired
	RedisTemplate redisTemplate;
	
	public static final String HASH_KEY = "Book";
	

	public  Book save(Book book) {
	

		redisTemplate.opsForHash().put(HASH_KEY,book.getId(),book);
		

		return book;
	}

	public List<Book> findAll() {
		return redisTemplate.opsForHash().values(HASH_KEY);
	}

	public Book findProductById(int id) {
		return (Book) redisTemplate.opsForHash().get(HASH_KEY, id);

	}

	public String deleteBook(int id) {
		redisTemplate.opsForHash().delete(HASH_KEY, id);
		return "product removed !!";
	}
}
