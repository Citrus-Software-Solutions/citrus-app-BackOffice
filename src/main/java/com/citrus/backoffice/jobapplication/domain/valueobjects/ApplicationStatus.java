package com.citrus.backoffice.jobapplication.domain.valueobjects;

public class ApplicationStatus {
	private int value;

	public ApplicationStatus(int value) {
		if (value < 0) value = 0;
		else if (value > 2) value = 2; 
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
