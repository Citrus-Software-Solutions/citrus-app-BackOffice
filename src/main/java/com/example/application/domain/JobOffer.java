package com.example.application.domain;

import com.example.application.domain.valueobjects.JobOfferDescription;
import com.example.application.domain.valueobjects.FinishingDate;
import com.example.application.domain.valueobjects.HourlyRate;
import com.example.application.domain.valueobjects.JobOfferId;
import com.example.application.domain.valueobjects.JobOfferStatus;
import com.example.application.domain.valueobjects.StartingDate;
import com.example.application.domain.valueobjects.Title;

public class JobOffer {
    private JobOfferId id;
    private Title title;
    private JobOfferDescription description;
    private Employer employer;
    private Location location;
    private StartingDate startingDate;
    private FinishingDate finishingDate;
    private HourlyRate hourlyRate;
    private JobOfferStatus status;
    //private Employee employee;
    
    public JobOfferId getId() {
    	return id;
    }
    
    public void setId(JobOfferId id) {
    	this.id = id;
    }
    
    public Title getTitle() {
    	return title;
    }
    public void setTitle(Title title) {
    	this.title = title;
    }
    
    public JobOfferDescription getDescription() {
    	return description;
    }
    
    public void setDescription(JobOfferDescription description) {
    	this.description = description;
    }
    
    public Employer getEmployer() {
    	return employer;
    }
    
    public void setEmployer(Employer employer) {
    	this.employer = employer;
    }

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public StartingDate getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(StartingDate starting) {
		this.startingDate = starting;
	}

	public FinishingDate getFinishingDate() {
		return finishingDate;
	}

	public void setFinishingDate(FinishingDate finishingDate) {
		this.finishingDate = finishingDate;
	}

	public JobOfferStatus getStatus() {
		return status;
	}

	public void setStatus(JobOfferStatus status) {
		this.status = status;
	}

	public HourlyRate getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(HourlyRate hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
}