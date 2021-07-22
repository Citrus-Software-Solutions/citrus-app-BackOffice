package com.citrus.backoffice.employee.domain;

import com.citrus.backoffice.employee.domain.valueobjects.BirthDate;
import com.citrus.backoffice.employee.domain.valueobjects.EmployeeName;
import com.citrus.backoffice.employee.domain.valueobjects.Gender;
import com.citrus.backoffice.shared.domain.User;
import com.citrus.backoffice.shared.domain.valueobjects.Document;
import com.citrus.backoffice.shared.domain.valueobjects.Email;
import com.citrus.backoffice.shared.domain.valueobjects.UserId;
import com.citrus.backoffice.shared.domain.valueobjects.Username;

public class Employee extends User{
    private EmployeeName fullName;
	private BirthDate birthDate;
	private Gender gender;
	
	public Employee(UserId id) {
		this.setId(id);
	}
	
	public Employee(
			UserId id,
			Document document,
			Username name,
			Email email,
			EmployeeName fullName,
			BirthDate birthDate,
			Gender gender) {
		this.setId(id);
		this.setDocument(document);;
		this.setName(name);
		this.setEmail(email);
		this.fullName = fullName;
		this.birthDate = birthDate;
		this.gender = gender;
	}
	
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