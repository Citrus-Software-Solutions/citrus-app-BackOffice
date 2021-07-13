package com.citrus.backoffice.employee.domain;

import com.citrus.backoffice.employee.domain.valueobjects.BirthDate;
import com.citrus.backoffice.employee.domain.valueobjects.EmployeeName;
import com.citrus.backoffice.employee.domain.valueobjects.Gender;
import com.citrus.backoffice.shared.domain.User;

public class Employee extends User{
    private EmployeeName fullName;
	private BirthDate birthDate;
	private Gender gender;
	
	public EmployeeName getFullName() {
		return fullName;
	}
	public void setFullName(EmployeeName fullName) {
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