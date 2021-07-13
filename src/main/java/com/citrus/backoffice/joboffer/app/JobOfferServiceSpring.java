package com.citrus.backoffice.joboffer.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

import com.citrus.backoffice.employer.domain.Employer;
import com.citrus.backoffice.employer.domain.valueobjects.EmployerName;
import com.citrus.backoffice.joboffer.domain.JobOffer;
import com.citrus.backoffice.joboffer.domain.valueobjects.FinishingDate;
import com.citrus.backoffice.joboffer.domain.valueobjects.JobOfferDescription;
import com.citrus.backoffice.joboffer.domain.valueobjects.JobOfferStatus;
import com.citrus.backoffice.joboffer.domain.valueobjects.StartingDate;
import com.citrus.backoffice.joboffer.domain.valueobjects.Title;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class JobOfferServiceSpring implements JobOfferService{
	@Value("${PORT: 3000}")
	private String serverPort;

    @Override
    public List<JobOffer> getJobOffers() {
    	List<JobOffer> offers = new ArrayList<>();
    	
    	// Fetch from 3rd party API; configure fetch
		final RequestHeadersSpec<?> spec = WebClient.create().get().uri("http://localhost:3000/JobOffer/view/");

		final List<JsonNode> posts = spec.retrieve().toEntityList(JsonNode.class).block().getBody();

		System.out.println(String.format("...received %d items.", posts.size()));
		
		for(JsonNode i:posts) {
			offers.add(JobOffer.createJobOffer( new Title(i.get("name").asText() ), 
								new Employer(new EmployerName("Banco Mercantil")),
								new JobOfferStatus( i.get("status").asText() ),
		                        new JobOfferDescription( i.get("description").asText() ),
		                        new StartingDate( i.get("date_Begin").asText() ),
		                        new FinishingDate( i.get("date_End").asText() )
		                        ));
		}

        return offers;
    }
    
}