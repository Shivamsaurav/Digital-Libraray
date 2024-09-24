package com.libr.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.libr.dtos.BookDto;
import com.libr.entities.Author;
import com.libr.entities.Book;
import com.libr.entities.Genre;
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
	public Book addBook(BookDto bookDto) {
		//Author author = authorRepo.findById(bookDto.getAuthorId()).get();
		Optional<Author> optionalAuth = authorRepo.findById(bookDto.getAuthorId());
		
		Author author = optionalAuth.orElseThrow(()->new RuntimeException("Invalid Author id."));
		
		Book book = new Book();
		BeanUtils.copyProperties(bookDto, book);
		book.setAuthor(author);
		
		bookRepo.save(book);
		return book;
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
	public List<Book> searchByGenre(Genre genre) {
		// TODO Auto-generated method stub
		return bookRepo.searchByGenre(genre);
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
