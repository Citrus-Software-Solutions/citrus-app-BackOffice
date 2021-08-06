package com.citrus.backoffice.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.citrus.backoffice.interview.app.InterviewMapperMock;
import com.citrus.backoffice.shared.ports.MockPort;
import com.citrus.backoffice.shared.ports.NestPort;
import com.citrus.backoffice.shared.ports.SpringPort;

public class APITest {

	@Tag("Unit")
	@Test
	void getRequestMock() {
		//Test if the APIPort connects to the Mock API and returns a JsonNode
		var port = new MockPort();
		assertNotNull(port.requestGet("Interview/1"));
	}
	
	@Tag("Unit")
	@Test
	void getRequestNest() {
		//Test if the APIPort connects to the Nest API and returns a JsonNode
		var port = new NestPort();
		assertNotNull(port.requestGet("users/1"));
	}
	
	@Tag("Unit")
	@Test
	void getRequestSpring() {
		//Test if the APIPort connects to the Spring API and returns a JsonNode
		var port = new SpringPort();
		assertNotNull(port.requestGet("interview/1"));
	}

	@Tag("Unit")
	@Test
	void getRequestListMock() {
		//Test if the APIPort connects to the Mock API and returns a JsonNode list
		var port = new MockPort();
		assertNotNull(port.requestGetList("Interview"));
		assertFalse(port.requestGetList("Interviews").isEmpty());
	}
	
	@Tag("Unit")
	@Test
	void getRequestListNest() {
		//Test if the APIPort connects to the Nest API and returns a JsonNode list
		var port = new NestPort();
		assertNotNull(port.requestGetList("job-offers"));
		assertFalse(port.requestGetList("job-offers").isEmpty());
	}
	
	@Tag("Unit")
	@Test
	void getRequestListSpring() {
		//Test if the APIPort connects to the Spring API and returns a JsonNode list
		var port = new SpringPort();
		assertNotNull(port.requestGetList("interview"));
		assertFalse(port.requestGetList("interview").isEmpty());
	}
	
	@Tag("Unit")
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
