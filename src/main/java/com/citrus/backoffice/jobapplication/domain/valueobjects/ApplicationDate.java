package com.citrus.backoffice.jobapplication.domain.valueobjects;

import java.util.Date;

public class ApplicationDate {
	private Date value;

	public ApplicationDate(Date value) {
		this.value = value;
	}
	
	public Date getValue() {
		return value;
	}
}
