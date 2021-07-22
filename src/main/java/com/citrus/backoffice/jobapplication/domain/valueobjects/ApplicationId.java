package com.citrus.backoffice.jobapplication.domain.valueobjects;

public class ApplicationId {
	private long value;
	
	public ApplicationId(long value) {
		this.value = value < 0 ? 0 : value;
	}
	
	public long getValue() {
		return value;
	}
}
