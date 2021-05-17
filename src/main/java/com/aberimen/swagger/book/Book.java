package com.aberimen.swagger.book;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Book {
	
	@Id
	private String ISBN;
	
	private String title;
	
	private String author;
	
	private int page;
	
}


