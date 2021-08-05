package com.citrus.backoffice.integration;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.citrus.backoffice.interview.app.InterviewMapperMock;
import com.citrus.backoffice.interview.domain.Interview;
import com.citrus.backoffice.shared.ports.MockPort;

public class InterviewServices {

	@Test
	void getInterview() {
		//Test if the APIPort's returned JsonNode is correctly mapped by the InterviewMapper
		var interview = new InterviewMapperMock().getInterview(new MockPort(), 1);
		
		//Should return something...
		assertNotNull(interview);
		//...other than the 404 interview (error)
		assertNotEquals(interview.getId().getValue(), 404);
	}
	
}
