package com.citrus.backoffice.joboffer.app;

import java.util.List;

import com.citrus.backoffice.joboffer.domain.JobOffer;
import com.citrus.backoffice.shared.ports.APIPort;

public interface JobOfferMapper {
	
    List<JobOffer> getJobOffers(APIPort port);
    JobOffer getJobOffer(APIPort port, long id);
    
}