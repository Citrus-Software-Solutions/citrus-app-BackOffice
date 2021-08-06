package com.citrus.backoffice.integration;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.citrus.backoffice.interview.app.InterviewMapperMock;
import com.citrus.backoffice.interview.app.InterviewMapperSpring;
import com.citrus.backoffice.interview.domain.Interview;
import com.citrus.backoffice.joboffer.app.JobOfferMapperNest;
import com.citrus.backoffice.shared.ports.MockPort;
import com.citrus.backoffice.shared.ports.NestPort;
import com.citrus.backoffice.shared.ports.SpringPort;

public class MapperTest {

	@Tag("Integration")
	@Test
	public void getInterview() {
		//Test if the APIPort's returned JsonNode is correctly mapped by the InterviewMapper
		var interview = new InterviewMapperSpring().getInterview(new SpringPort(), 1);
		
		//Should return something...
		assertNotNull(interview);
		//...other than the 404 interview (error)
		assertNotEquals(interview.getId().getValue(), 404);
	}
	
	@Tag("Integration")
	@Test
	public void getJobOffer() {
		//Test if the APIPort's returned JsonNode is correctly mapped by the InterviewMapper
		var offer = new JobOfferMapperNest().getJobOffer(new NestPort(), 1);
		
		//Should return something...
		assertNotNull(offer);
		//...other than the 404 interview (error)
		//assertNotEquals(offer.getId().getValue(), 404);
	}
	
}
