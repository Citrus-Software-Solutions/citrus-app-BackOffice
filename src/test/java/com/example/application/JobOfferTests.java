package com.example.application;

import org.junit.jupiter.api.*;

import com.example.application.domain.Employee;
import com.example.application.domain.Employer;
import com.example.application.domain.JobOffer;
import com.example.application.domain.valueobjects.FinishingDate;
import com.example.application.domain.valueobjects.FullName;
import com.example.application.domain.valueobjects.JobOfferDescription;
import com.example.application.domain.valueobjects.JobOfferId;
import com.example.application.domain.valueobjects.StartingDate;
import com.example.application.domain.valueobjects.Title;
import com.example.application.domain.valueobjects.UserId;

import java.util.Date;

import static org.junit.Assert.*;

class JobOfferTests {
	@Test
	void createOffer() {
		FullName fullName = new FullName("Duke Nukem");
		JobOffer offer = new JobOffer();
		Employer employer = new Employer(fullName);
		
		employer.setId(new UserId(1));
		
		offer.setId(new JobOfferId(1));
		offer.setTitle(new Title("Software Testing"));
		offer.setDescription(new JobOfferDescription("This is some terrible software, please test it!"));
		offer.setStartingDate(new StartingDate("2012-12-12"));
		offer.setFinishingDate(new FinishingDate("2012-12-15"));
		offer.setEmployer(employer);
		
		assertNotNull(offer.getId());
		assertNotNull(offer.getTitle());
		assertNotNull(offer.getDescription());
		assertNotNull(offer.getStartingDate());
		assertNotNull(offer.getFinishingDate());
		assertNotNull(offer.getEmployer());
		assertEquals(offer.getEmployer(), employer);
	}
	
	@Test
	void employeeInsert() {
		JobOffer offer = new JobOffer();
		Employee employee = new Employee();
		
		employee.setId(new UserId(1));
		offer.setId(new JobOfferId(1));
		offer.setEmployee(employee);
		
		assertNotNull(offer.getId());
		assertNotNull(offer.getEmployee());
		assertEquals(offer.getEmployee(), employee);
	}
}
