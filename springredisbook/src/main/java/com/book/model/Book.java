 package com.book.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Book")
public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String bookName;
	private String author;
	private String bookPublishdate;
	private String numberOfPagesInBook;

}
