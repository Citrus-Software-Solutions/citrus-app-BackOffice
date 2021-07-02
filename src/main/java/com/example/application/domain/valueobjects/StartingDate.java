package com.example.application.domain.valueobjects;

import java.util.Date;

public class StartingDate {
	private Date value;
	
	public StartingDate(Date value) {
		this.value = value;
	}
	
	public Date getValue() {
		return value;
	}
}