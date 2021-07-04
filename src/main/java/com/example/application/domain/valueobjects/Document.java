package com.example.application.domain.valueobjects;

public class Document {
	private long value;
	
	public Document(long value) {
		this.value = value < 0 ? 0 : value;
	}
	
	public long getValue() {
		return value;
	}
}