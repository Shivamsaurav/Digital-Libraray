package com.libr.dtos;

import com.libr.entities.Genre;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class BookDto {

	private int bookId;
	private String bookName;
	@Enumerated(EnumType.STRING)
	private Genre genre;
	private float price;
	private int stock;
	private int authorId;
}
