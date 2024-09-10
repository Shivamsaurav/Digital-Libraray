package com.libr.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.libr.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

	@Query(value = "select * from Transaction t where user_id=:u", nativeQuery = true)
	List<Transaction> searchTransactionByUser(@Param("u") int userid);
}
