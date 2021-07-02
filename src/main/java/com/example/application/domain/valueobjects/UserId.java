package com.example.application.domain.valueobjects;

public class UserId {
	private long value;
	
	public UserId(long value) {
		this.value = value < 1 ? 1 : value;
	}
	
	public long getValue() {
		return value;
	}
}