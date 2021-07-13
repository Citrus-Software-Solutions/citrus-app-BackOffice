package com.citrus.backoffice.shared.domain.valueobjects;

public class LocationId {
	private long value;
	
	public LocationId(long value) {
		this.value = value < 1 ? 1 : value;
	}
	
	public long getValue() {
		return this.value;
	}
}