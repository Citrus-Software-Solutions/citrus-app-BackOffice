package com.example.application;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import com.example.application.domain.Employer;
import com.example.application.domain.Location;
import com.example.application.domain.valueobjects.Email;
import com.example.application.domain.valueobjects.FullName;
import com.example.application.domain.valueobjects.LocationId;
import com.example.application.domain.valueobjects.LocationName;
import com.example.application.domain.valueobjects.LocationType;
import com.example.application.domain.valueobjects.UserId;
import com.example.application.domain.valueobjects.UserName;

class EmployerTests {
	@Test
	void idIsPositive() {
		Employer employer = new Employer();
		
		employer.setId(new UserId(-1));
		
		assertEquals(employer.getId().getValue(), 1);
	}
	
	@Test
	void userNameInsert() {
		Employer employer = new Employer();
		
		employer.setName(new UserName("dukenukem97"));
		
		assertNotNull(employer.getName());
	}
	
	@Test
	void emailInsert() {
		Employer employer = new Employer();
		
		employer.setEmail(new Email("duke@mail.com"));
		
		assertNotNull(employer.getEmail());
	}
	
	@Test
	void fullNameInsert() {
		Employer employer = new Employer();
		
		employer.setFullName(new FullName("Duke Nukem"));
		
		assertNotNull(employer.getFullName());
	}
	
	@Test
	void locationInsert() {
		Employer employer = new Employer();
		Location location = new Location(new LocationId(1), new LocationName("Manhattan"), new LocationType("City"));
		
		employer.setLocation(location);
		
		assertNotNull(employer.getLocation());
		assertEquals(employer.getLocation(), location);
	}
}