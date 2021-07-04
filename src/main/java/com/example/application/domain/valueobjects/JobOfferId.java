package com.example.application.domain.valueobjects;

public class JobOfferId {
	private long value;
	
	public JobOfferId(long value) {
		this.value = value < 0 ? 0 : value;
	}
	
	public long getValue() {
		return value;
	}
}