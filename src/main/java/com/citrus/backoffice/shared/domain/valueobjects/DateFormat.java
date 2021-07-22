package com.citrus.backoffice.shared.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DateFormat {
	private String value;
	
	public DateFormat(@JsonProperty("date") String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}