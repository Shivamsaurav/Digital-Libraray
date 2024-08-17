package com.mint.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Penalty {

	@Id
	private int penaltyId;
	private float amount;
	private String remarks;
	private int numberOfDays;
	
}
