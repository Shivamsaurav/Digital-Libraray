package com.libr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.libr.dtos.BorrowBookDto;
import com.libr.entities.Book;
import com.libr.entities.Transaction;
import com.libr.entities.User;
import com.libr.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping
	public User addUser(@RequestBody User user) {
		return userService.addNewUser(user);
	}
	
	@PostMapping("/borrowbook")
	public Book borrowBook(@RequestBody BorrowBookDto borrowBookDto) {
		return userService.borrowBook(borrowBookDto.getBookId(), borrowBookDto.getUserId());
	}
	
	@GetMapping("/transaction")
	public List<Transaction> checkUserTransaction(@RequestParam("uid") int userId){
		return userService.checkTransactionByuser(userId);
	}
	
	@PutMapping("/returnbook/{tid}")
	public Book returnBook(@PathVariable int tid) {
		return userService.returnBook(tid);
	}
}
