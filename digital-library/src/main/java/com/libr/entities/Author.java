package com.libr.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Author {
	
	@Id
	private int authorId;
	private String nameOfAuthor;
}
