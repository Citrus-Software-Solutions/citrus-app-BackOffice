package com.example.application.domain;

import com.example.application.domain.valueobjects.FullName;

public class Employer extends User {
	private FullName fullName;
	
	public Employer(FullName fullName) {
		setFullName(fullName);
	}

	public FullName getFullName() {
		return fullName;
	}

	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}
}
