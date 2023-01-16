package com.user.service.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="user") 
public class User {
	
	@Id
	private String userId;
	private String name;
	private String email;
	private String about;
	@Transient                                      // data not save in database
	private List<Rating> ratings=new ArrayList<>();

}
