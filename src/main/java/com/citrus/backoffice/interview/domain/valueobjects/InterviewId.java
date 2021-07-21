package com.citrus.backoffice.interview.domain.valueobjects;

public class InterviewId {
	private long value;
	
	public InterviewId(long value) {
		this.value = value < 0 ? 0 : value;
	}
	
	public long getValue() {
		return value;
	}
}
