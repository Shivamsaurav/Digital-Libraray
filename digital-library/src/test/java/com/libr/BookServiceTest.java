package com.libr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import com.libr.dtos.BookDto;
import com.libr.entities.Author;
import com.libr.entities.Book;
import com.libr.entities.Transaction;
import com.libr.repositories.AuthorRepository;
import com.libr.repositories.BookRepository;
import com.libr.repositories.PenaltyRepository;
import com.libr.repositories.TransactionRepository;
import com.libr.services.impl.BookServiceImpl;
import com.libr.services.impl.UserServiceImpl;

@SpringBootTest
public class BookServiceTest {

	@Mock
	private AuthorRepository authorRepo;
	
	@Mock
	private BookRepository bookRepo;
	
	@Mock
	private TransactionRepository transactRepo;
	
	@Mock
	private PenaltyRepository penaltyRepo;
	
	@InjectMocks
	private UserServiceImpl userService;
	
	@InjectMocks
	private BookServiceImpl bookService;
	
	@Test
	public void addBookTestSuccess() {
		
		BookDto bookDto = new BookDto();
		bookDto.setBookId(1);
		bookDto.setBookName("Test Book");
		bookDto.setPrice(100);
		bookDto.setAuthorId(101);
		
		Author author = new Author();
		author.setAuthorId(101);
		author.setNameOfAuthor("Test Author");
		// PRE-CONDITION
		when(authorRepo.findById(bookDto.getAuthorId()))
		.thenReturn(Optional.of(author));
		
		bookService.addBook(bookDto);
		
		Book addedBook = new Book();
		addedBook.setAuthor(author);
		BeanUtils.copyProperties(bookDto,addedBook);
		
		when(bookRepo.save(any(Book.class))).thenReturn(addedBook);
		
		assertEquals(addedBook.getAuthor().getNameOfAuthor(), "Test Author");
		
		// to verify the service has called the Repository or not.
		verify(authorRepo,times(1)).findById(101);
		verify(bookRepo,times(1)).save(any(Book.class));
	}
	
	@Test
	public void addBookTestFailure() {
		
		BookDto bookDto = new BookDto();
		bookDto.setBookId(1);
		bookDto.setBookName("Test Book");
		bookDto.setPrice(100);
		bookDto.setAuthorId(101);
		
		Author author = new Author();
		author.setAuthorId(1);
		author.setNameOfAuthor("Test Author"); 
		
		when(authorRepo.findById(1)).thenReturn(Optional.empty());
		
		Exception e =  
		assertThrows(RuntimeException.class, ()->bookService.addBook(bookDto));
		assertEquals("Invalid Author id.", e.getMessage());
		
		verify(bookRepo,times(0)).save(any(Book.class));
	}
	
	@Test
	public void testBookReturnWithPenalty() {
		
		int transactionId = 1;
		Transaction t = new Transaction();
		t.setTransactionId(transactionId);
		t.setBorrowDate(LocalDate.now().minusDays(12));
		Book book = new Book();
		book.setBookName("Test Book");
		t.setBook(book);
		when(transactRepo.findById(1)).thenReturn(Optional.of(t));
		Book returnedBook = 
		userService.returnBook(1);
		
		assertEquals(book.getBookName(), returnedBook.getBookName());
		
		verify(transactRepo,times(1)).save(any(Transaction.class));
		
		assertEquals(100, t.getPenalty().getAmount());
		
	}
	
	
}
