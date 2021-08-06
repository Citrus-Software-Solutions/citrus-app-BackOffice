package com.citrus.backoffice.employer.domain;

import javax.persistence.Entity;

import com.citrus.backoffice.employee.domain.Employee;
import com.citrus.backoffice.employer.domain.valueobjects.EmployerName;
//import com.citrus.backoffice.shared.domain.User;
import com.citrus.backoffice.shared.domain.valueobjects.DateFormat;

@Entity
public class Employer /*extends User*/ {
	String id;
	//EmployerName employerName;
	String employerName;
	String address;
	String[] contacts;
	String[] skills;
	String special_requirements;
	String status;
	
	public Employer(String id,
					//EmployerName employerName,
					String employerName,
					String address,
					String[] contacts,
					String[] skills,
					String special_requirements,
					String status) {
		this.employerName = employerName;
		this.id = id;
		this.employerName = employerName;
		this.address = address;
		this.contacts = contacts;
		this.skills = skills;
		this.special_requirements = special_requirements;
		this.status = status;
	}
	
	public String getId() {
		return address;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String[] getContacts() {
		return contacts;
	}
	
	public void setContacts(String[] contacts) {
		this.contacts = contacts;
	}
	
	public String[] getSkills() {
		return skills;
	}
	
	public void setSkills(String[] skills) {
		this.skills = skills;
	}
	
	public String getSpecial_requirements() {
		return special_requirements;
	}
	
	public void setSpecial_requirements(String special_requirements) {
		this.special_requirements = special_requirements;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
