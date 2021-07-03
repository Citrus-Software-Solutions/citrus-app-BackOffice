package com.example.application;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import com.example.application.domain.Employee;
import com.example.application.domain.Location;
import com.example.application.domain.valueobjects.Email;
import com.example.application.domain.valueobjects.FullName;
import com.example.application.domain.valueobjects.Gender;
import com.example.application.domain.valueobjects.LocationId;
import com.example.application.domain.valueobjects.LocationName;
import com.example.application.domain.valueobjects.LocationType;
import com.example.application.domain.valueobjects.UserId;
import com.example.application.domain.valueobjects.UserName;

class EmployeeTests {
	@Test
	void idIsPositive() {
		Employee employee = new Employee();
		
		employee.setId(new UserId(-25));
		
		assertEquals(employee.getId().getValue(), 1);
	}
	
	@Test
	void userNameInsert() {
		Employee employee = new Employee();
		UserName userName = new UserName("dukenukem3d");
		
		employee.setName(userName);
		
		assertNotNull(employee.getName());
		assertEquals(employee.getName(), userName);
	}
	
	@Test
	void emailInsert() {
		Employee employee = new Employee();
		Email email = new Email("duke@mail.com");
		
		employee.setEmail(email);
		
		assertNotNull(employee.getEmail());
		assertEquals(employee.getEmail(), email);
	}
	
	@Test
	void fullNameInsert() {
		Employee employee = new Employee();
		FullName fullName = new FullName("Duke Nukem");
		
		employee.setFullName(fullName);
		
		assertNotNull(employee.getFullName());
		assertEquals(employee.getFullName(), fullName);
	}
	
	@Test
	void locationInsert() {
		Employee employee = new Employee();
		Location location = new Location(new LocationId(1), new LocationName("Manhattan"), new LocationType("City"));
		
		employee.setLocation(location);
		
		assertNotNull(employee.getLocation());
		assertEquals(employee.getLocation(), location);
	}
	
	@Test
	void genderInsert() {
		Employee employee = new Employee();
		Gender gender = new Gender('M');
		
		employee.setGender(gender);
		
		assertNotNull(employee.getGender());
		assertEquals(employee.getGender(), gender);
	}
}