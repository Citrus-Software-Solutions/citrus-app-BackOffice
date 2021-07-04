package com.example.application.domain.valueobjects;

import java.util.Date;

public class FinishingDate {
	private String value;
	
	public FinishingDate(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}