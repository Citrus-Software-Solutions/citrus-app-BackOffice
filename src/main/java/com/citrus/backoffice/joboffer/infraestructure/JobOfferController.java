package com.citrus.backoffice.joboffer.infraestructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citrus.backoffice.joboffer.app.JobOfferService;
import com.citrus.backoffice.joboffer.domain.JobOffer;

@RestController
public class JobOfferController {
	@Autowired
    JobOfferService service;

    @GetMapping
    public List<JobOffer> getJobOffers() {
        return service.getJobOffers();
    }
}