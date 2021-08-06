package com.citrus.backoffice.joboffer.app;

import java.util.ArrayList;
import java.util.List;

import com.citrus.backoffice.employer.domain.Employer;
import com.citrus.backoffice.employer.domain.valueobjects.EmployerName;
import com.citrus.backoffice.joboffer.domain.JobOffer;
import com.citrus.backoffice.joboffer.domain.valueobjects.Deadline;
import com.citrus.backoffice.joboffer.domain.valueobjects.Duration;
import com.citrus.backoffice.joboffer.domain.valueobjects.HourlyRate;
import com.citrus.backoffice.joboffer.domain.valueobjects.JobOfferId;
import com.citrus.backoffice.joboffer.domain.valueobjects.JobOfferStatus;
import com.citrus.backoffice.joboffer.domain.valueobjects.Title;
import com.citrus.backoffice.shared.domain.Address;
import com.citrus.backoffice.shared.domain.valueobjects.City;
import com.citrus.backoffice.shared.domain.valueobjects.State;
import com.citrus.backoffice.shared.domain.valueobjects.Street1;
import com.citrus.backoffice.shared.domain.valueobjects.Street2;
import com.citrus.backoffice.shared.domain.valueobjects.UserId;
import com.citrus.backoffice.shared.domain.valueobjects.Zip;
import com.citrus.backoffice.shared.ports.APIPort;
import com.fasterxml.jackson.databind.JsonNode;

public class JobOfferMapperMock implements JobOfferMapper {

	@Override
	public List<JobOffer> getJobOffers(APIPort port) {
		List<JobOffer> offers = new ArrayList<>();
		
		for (JsonNode n: port.requestGetList("JobOffer")) {
			offers.add(JobOffer.createJobOffer(
					new JobOfferId(n.get("id").asLong()),
					new Title(n.get("title").asText()),
					new Employer(
							new EmployerName(n.get("employer").get("company_name").asText())),
					JobOfferStatusTranslator.getStatus(n.get("status").asInt()), 
					new Deadline(n.get("dead_line").asText())));
		}
		
		return offers;
	}

	@Override
	public JobOffer getJobOffer(APIPort port, long id) {
		var offer = new JobOffer();
		var node = port.requestGet("JobOffer/" + String.valueOf(id));
		
		offer.setId(new JobOfferId(node.get("id").asLong()));
		offer.setTitle(new Title(node.get("title").asText()));
		offer.setEmployer(new Employer(new EmployerName(node.get("employer").get("company_name").asText())));
		offer.setStatus(JobOfferStatusTranslator.getStatus(node.get("status").asInt()));
		offer.setHourlyRate(new HourlyRate(node.get("hourly_rate").asDouble()));
		offer.setDuration(new Duration(node.get("duration").asInt()));
		offer.setAddress(new Address(
				new Street1(node.get("location").get("street1").asText()),
				new Street2(node.get("location").get("street2").asText()),
				new City(node.get("location").get("city").asText()),
				new State(node.get("location").get("state").asText()),
				new Zip(node.get("location").get("_zip").asText())));
		
		return offer;
	}

}
