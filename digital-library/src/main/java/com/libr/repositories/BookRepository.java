package com.libr.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.libr.entities.Book;
import com.libr.entities.Genre;

public interface BookRepository extends JpaRepository<Book, Integer>{

	@Query(name = "SearchBookByGenre")
	List<Book> searchByGenre(@Param("g") Genre genre);
}
