package com.libr.services.impl;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.libr.entities.Book;
import com.libr.entities.Penalty;
import com.libr.entities.Transaction;
import com.libr.entities.User;
import com.libr.repositories.BookRepository;
import com.libr.repositories.PenaltyRepository;
import com.libr.repositories.TransactionRepository;
import com.libr.repositories.UserRepository;
import com.libr.services.UserService;

import jakarta.transaction.Transactional;

@Component
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private TransactionRepository transactionRepo;
	
	@Autowired
	private PenaltyRepository penaltyRepo;
	
	@Override
	public User addNewUser(User user) {		
		return userRepo.save(user);
	}

	@Override
	@Transactional // @Transactional(propagation = Propagation.REQUIRED)
	public Book borrowBook(int bookId, int userId) {
		if(checkavailability(bookId)) {
		Book book = bookRepo.findById(bookId).orElseThrow(()->new RuntimeException("Book not Found"));
		
		User user = userRepo.findById(userId).orElseThrow(()-> new RuntimeException("User not Found"));
		
		Transaction transaction = new Transaction();
		transaction.setBorrowDate(LocalDate.now());
		transaction.setBook(book);
		transaction.setUser(user);
		book.setStock(book.getStock()-1);
		transactionRepo.save(transaction);
		bookRepo.save(book);
		return book;
		}
		else
			return null;
		
	}

	@Override
	public Book returnBook(int transactionId) {
		Transaction transact = transactionRepo.findById(transactionId).orElseThrow(()->new RuntimeException("Invalid transaction id"));
		LocalDate borrowDate = transact.getBorrowDate();
		LocalDateTime borrowDateTime = borrowDate.atStartOfDay();
		LocalDateTime currDate = LocalDateTime.now();
		Duration duration = Duration.between(borrowDateTime, currDate);
		long dateDiff = duration.toDays();
		if(dateDiff >10) {
			Penalty penalty = new Penalty();
			int amount = (int)((dateDiff-10)*50);
			penalty.setAmount(amount);
			penalty.setNumberOfDays((int)dateDiff);
			penalty.setRemarks("Late Fine.");
			penaltyRepo.save(penalty);
			transact.setPenalty(penalty);
		}
		transact.setReturnedDate(LocalDate.now());
		transactionRepo.save(transact);
		Book book = transact.getBook();
		return book;
	}

	@Override
	public boolean checkavailability(int bookId) {
		Book book = bookRepo.findById(bookId).orElseThrow(()->new RuntimeException("Book not Found"));
		
		if(book.getStock()>0)
			return true;
		return false;
	}

	@Override
	public List<Transaction> checkTransactionByuser(int userId) {
		return transactionRepo.searchTransactionByUser(userId) ;
	}

}
