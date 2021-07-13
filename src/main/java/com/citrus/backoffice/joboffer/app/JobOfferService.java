package com.citrus.backoffice.joboffer.app;

import java.util.List;

import com.citrus.backoffice.joboffer.domain.JobOffer;

public interface JobOfferService {
    List<JobOffer> getJobOffers();
}