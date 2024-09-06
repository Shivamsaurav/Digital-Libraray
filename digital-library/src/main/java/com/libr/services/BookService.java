package com.libr.services;

import java.util.List;

import com.libr.dtos.BookDto;
import com.libr.entities.Author;
import com.libr.entities.Book;

public interface BookService {

	Author addAuthor(Author author);
	Book addBook(BookDto bookDto);
	List<Book> getAllBooks();
	List<Book> searchByAuthor(int AuthorId);
	List<Book> searchByGenre(String genre);
	Book updateBook(Book book, int BookId);
	void deleteBook(int bookId);
	
}
