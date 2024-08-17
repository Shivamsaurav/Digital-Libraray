package com.mint.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Book {

	@Id
	private int bookId;
	private String bookName;
	private Genre genre;
	private float price;
	private int stock;
}
