package com.mint.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Book {

	@Id
	private int bookId;
	private String bookName;
	@Enumerated(EnumType.STRING)
	private Genre genre;
	private float price;
	private int stock;
	
	@ManyToOne
	@JoinColumn(name="authorId")
	private Author author;
}
