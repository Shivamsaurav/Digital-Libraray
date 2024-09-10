package com.libr.services;

import java.util.List;

import com.libr.entities.Book;
import com.libr.entities.Transaction;
import com.libr.entities.User;

public interface UserService {

	User addNewUser(User user);
	Book borrowBook(int bookId, int userId);
	Book returnBook(int transactionId);
	boolean checkavailability(int bookId);
	List<Transaction> checkTransactionByuser(int userId);
}
