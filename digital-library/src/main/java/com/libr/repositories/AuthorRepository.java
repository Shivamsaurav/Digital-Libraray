package com.libr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libr.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{

}
