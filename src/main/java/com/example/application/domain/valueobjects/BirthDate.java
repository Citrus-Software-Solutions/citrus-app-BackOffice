package com.example.application.domain.valueobjects;

import java.util.Date;

public class BirthDate {
	private Date value;
	
	public BirthDate(Date value) {
		this.value = value;
	}
	
	public Date getValue() {
		return value;
	}
}