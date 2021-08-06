package com.citrus.backoffice.joboffer.domain.valueobjects;

public class HourlyRate {
	private double value;
	
	public HourlyRate(double d) {
		this.value = d < 0 ? 0 : d;
	}
	
	public double getValue() {
		return value;
	}
}