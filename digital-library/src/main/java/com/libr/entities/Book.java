package com.libr.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@NamedQuery(query = "select b from Book b where b.genre = :g", name = "SearchBookByGenre")
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
	@JsonIgnore
	private Author author;
}
