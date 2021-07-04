package com.example.application.domain.valueobjects;

import java.util.Date;

public class FinishingDate {
	private Date value;
	
	public FinishingDate(Date value) {
		this.value = value;
	}
	
	public Date getValue() {
		return this.value;
	}
}