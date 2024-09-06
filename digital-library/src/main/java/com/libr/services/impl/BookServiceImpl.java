package com.libr.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.libr.dtos.BookDto;
import com.libr.entities.Author;
import com.libr.entities.Book;
import com.libr.repositories.AuthorRepository;
import com.libr.repositories.BookRepository;
import com.libr.services.BookService;

@Component
public class BookServiceImpl implements BookService{

	@Autowired
	private AuthorRepository authorRepo;
	
	@Autowired
	private BookRepository bookRepo;
	
	@Override
	public Author addAuthor(Author author) {
		authorRepo.save(author);
		return author;
	}

	@Override
	public Book addBook(BookDto book, int authorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> searchByAuthor(int AuthorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> searchByGenre(String genre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book updateBook(Book book, int BookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBook(int bookId) {
		// TODO Auto-generated method stub
		
	}

}
