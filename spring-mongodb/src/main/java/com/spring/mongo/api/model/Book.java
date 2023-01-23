package com.spring.mongo.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Document(collection="book") 
public class Book {
	@Transient
	public static final String SEQUENCE_NAME="user_sequence";
	@Id
	private int id;
	@NotNull(message="Please Enter Vaild Data")
	private String bookName;
	@NotNull(message="Please Enter Vaild Data")
	private String author;
	@NotNull(message="Please Enter Vaild Data")
	private String bookPublishdate;
	@NotNull(message="Please Enter Vaild Data")
    private int numberOfPagesInBook;
	@NotNull(message="Please Enter Vaild Data")
	private int priceOfBook;
	boolean isActive=true;
	
}
