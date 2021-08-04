package com.citrus.backoffice.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.citrus.backoffice.interview.app.InterviewServiceMock;
import com.citrus.backoffice.interview.domain.valueobjects.InterviewId;
import com.citrus.backoffice.interview.infraestructure.InterviewUpdaterMock;

class APITest {

	@Test
	@BeforeAll
	void canGetInterview() {
		var service = new InterviewServiceMock();
		var number = Long.parseLong("1");
		var interview = service.getInterview(number);
		//var service = new InterviewServiceSpring();
		
		System.out.print(number);
		
		assertNotNull(interview);
		assertNotEquals(interview.getEmployee().getId().getValue(), 16);
	}

	@Test
	void canUpdateDate() {
		var updater = new InterviewUpdaterMock();
		var service = new InterviewServiceMock();
		var number = Long.parseLong("1");
		
		updater.updateDate(new InterviewId(number), "10-10-2010");
		var interview = service.getInterview(number);
		
		assertNotNull(interview);
		assertEquals("10-10-2010", interview.getStartDate().getValue());
	}
	
}
