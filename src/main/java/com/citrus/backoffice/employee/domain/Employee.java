package com.citrus.backoffice.employee.domain;

import com.citrus.backoffice.employee.domain.valueobjects.BirthDate;
import com.citrus.backoffice.employee.domain.valueobjects.EmployeeName;
import com.citrus.backoffice.employee.domain.valueobjects.FirstName;
import com.citrus.backoffice.employee.domain.valueobjects.Gender;
import com.citrus.backoffice.employee.domain.valueobjects.LastName;
import com.citrus.backoffice.employee.domain.valueobjects.MiddleName;
import com.citrus.backoffice.employee.domain.valueobjects.PhoneNumber;
import com.citrus.backoffice.shared.domain.User;
import com.citrus.backoffice.shared.domain.valueobjects.Document;
import com.citrus.backoffice.shared.domain.valueobjects.Email;
import com.citrus.backoffice.shared.domain.valueobjects.UserId;
import com.citrus.backoffice.shared.domain.valueobjects.Username;

public class Employee extends User{
	@Deprecated
	private EmployeeName fullName;
    private FirstName firstName;
    private MiddleName middleName;
    private LastName lastName;
    private PhoneNumber phoneNumber;
	private BirthDate birthDate;
	private Gender gender;
	
	public Employee(UserId id) {
		this.setId(id);
	}
	
	public Employee(UserId id, FirstName firstName, MiddleName middleName, LastName lastName) {
		this.setId(id);
		this.setFirstName(firstName);
		this.setMiddleName(middleName);
		this.setLastName(lastName);
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

	public FirstName getFirstName() {
		return firstName;
	}

	public void setFirstName(FirstName firstName) {
		this.firstName = firstName;
	}

	public MiddleName getMiddleName() {
		return middleName;
	}

	public void setMiddleName(MiddleName middleName) {
		this.middleName = middleName;
	}

	public LastName getLastName() {
		return lastName;
	}

	public void setLastName(LastName lastName) {
		this.lastName = lastName;
	}

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}