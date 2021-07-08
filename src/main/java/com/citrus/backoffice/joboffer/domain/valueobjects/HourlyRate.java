package com.citrus.backoffice.joboffer.domain.valueobjects;

public class HourlyRate {
	private float value;
	
	public HourlyRate(float value) {
		this.value = value < 0 ? 0 : value;
	}
	
	public float getValue() {
		return value;
	}
}