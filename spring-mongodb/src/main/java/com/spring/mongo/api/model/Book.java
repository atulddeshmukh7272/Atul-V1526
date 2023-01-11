package com.spring.mongo.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="book") 
public class Book {
	@Transient
	public static final String SEQUENCE_NAME="user_sequence";
	@Id
	private int id;
	private String bookName;
	private String authorName;
	private String bookPublishdate;
    private int numberOfPagesInBook;
	private int priceOfBook;
	
	boolean isActive=true;

}
