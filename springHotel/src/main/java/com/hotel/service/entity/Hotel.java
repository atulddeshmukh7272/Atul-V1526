package com.hotel.service.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="hotel") 
public class Hotel {
	private String id;
	private String name;
	private String location;
	private String about;

}
