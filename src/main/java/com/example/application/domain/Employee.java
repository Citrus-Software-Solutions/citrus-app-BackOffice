package com.example.application.domain;

import com.example.application.domain.valueobjects.BirthDate;
import com.example.application.domain.valueobjects.FullName;
import com.example.application.domain.valueobjects.Gender;

public class Employee extends User{
	private FullName fullName;
	private BirthDate birthDate;
	private Gender gender;
	
	public FullName getFullName() {
		return fullName;
	}
	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}
	public BirthDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(BirthDate birthDate) {
		this.birthDate = birthDate;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
}