package com.citrus.backoffice.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.citrus.backoffice.interview.app.InterviewMapperMock;
import com.citrus.backoffice.shared.ports.MockPort;

class APITest {

	@Test
	void getRequest() {
		//Test is the APIPort connects to the API and returns a JsonNode
		var port = new MockPort();
		assertNotNull(port.requestGet("Interview/1"));
	}

	@Test
	@Disabled
	void canUpdateDate() {
		var mapper = new InterviewMapperMock();
		var number = Long.parseLong("1");
		var interview = mapper.getInterview(new MockPort(), number);
		
		mapper.rescheduleInterview(new MockPort(), "10/10/2010", interview);
		interview = mapper.getInterview(new MockPort(), number);
		
		assertNotNull(interview);
		assertEquals("10/10/2010", interview.getStartDate().getValue());
	}
	
}
