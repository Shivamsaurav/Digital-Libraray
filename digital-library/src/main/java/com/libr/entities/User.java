package com.libr.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class User {
	
	@Id
	private int userId;
	private String userName;
	private String email;
	private String phoneNumber;
	private String address;
	
}
