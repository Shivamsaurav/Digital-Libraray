package com.libr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libr.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
