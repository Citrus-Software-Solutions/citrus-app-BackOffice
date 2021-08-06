package com.citrus.backoffice.shared.domain.valueobjects;

public class SkillId {
	private long value;
	
	public SkillId(long value) {
		this.value = value < 0 ? 0 : value;
	}
	
	public long getValue() {
		return this.value;
	}
}
