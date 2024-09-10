package com.libr.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Author {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq")
    @SequenceGenerator(name = "author_seq", sequenceName = "author_sequence", allocationSize = 1, initialValue = 10001)
    private int authorId;
	@NotBlank(message = "Author cannot be blank.")
	private String nameOfAuthor;
	
	@OneToMany(mappedBy = "author")
	private List<Book> books;
}
