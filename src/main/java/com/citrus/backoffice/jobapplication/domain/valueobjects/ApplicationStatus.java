package com.citrus.backoffice.jobapplication.domain.valueobjects;

public class ApplicationStatus {
	private String value;
	
	public ApplicationStatus(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
