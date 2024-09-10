package com.libr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.libr.dtos.BookDto;
import com.libr.entities.Author;
import com.libr.entities.Book;
import com.libr.entities.Genre;
import com.libr.services.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping("/author")
	public Author addNewAuthor(@Valid @RequestBody Author author) {
		return bookService.addAuthor(author);
	}
	
	@PostMapping
	public Book addNewBook(@RequestBody BookDto bookDto) {
		return bookService.addBook(bookDto);
	}
	
	
	@GetMapping("/search/genre")
	public List<Book> searchByGenre(@RequestParam Genre genre) {
		return bookService.searchByGenre(genre);
	}
}
