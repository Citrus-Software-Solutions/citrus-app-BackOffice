package com.citrus.backoffice.joboffer.domain;

import java.util.List;

import com.citrus.backoffice.employee.domain.Employee;
import com.citrus.backoffice.employer.domain.Employer;
import com.citrus.backoffice.joboffer.domain.valueobjects.Deadline;
import com.citrus.backoffice.joboffer.domain.valueobjects.Duration;
import com.citrus.backoffice.joboffer.domain.valueobjects.HourlyRate;
import com.citrus.backoffice.joboffer.domain.valueobjects.JobOfferDescription;
import com.citrus.backoffice.joboffer.domain.valueobjects.JobOfferId;
import com.citrus.backoffice.joboffer.domain.valueobjects.JobOfferStatus;
import com.citrus.backoffice.joboffer.domain.valueobjects.StartingDate;
import com.citrus.backoffice.joboffer.domain.valueobjects.Title;
import com.citrus.backoffice.shared.domain.Address;
import com.citrus.backoffice.shared.domain.Location;
import com.citrus.backoffice.shared.domain.Skill;
import com.citrus.backoffice.shared.domain.valueobjects.DateFormat;

public class JobOffer {
    private JobOfferId id;
    private Title title;
    @Deprecated
    private JobOfferDescription description;
    private Employer employer;
    @Deprecated
    private Location location;
    private Address address;
    @Deprecated
    private StartingDate startingDate;
    private Deadline deadline;
    private HourlyRate hourlyRate;
    private JobOfferStatus status;
	private Employee employee;
	private Duration duration;
	private List<DateFormat> schedules;
	private List<Skill> skills;
    
	public JobOffer() {
		
	}
	
	public JobOffer(JobOfferId id, Title title) {
		this.id = id;
		this.title = title;
	}
	
	
	
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

	public Deadline getDeadline() {
		return deadline;
	}

	public void setDeadline(Deadline deadline) {
		this.deadline = deadline;
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public static JobOffer createJobOffer (JobOfferId id, Title title, Employer employer,
				JobOfferStatus status, Deadline deadline) {
	JobOffer j = new JobOffer();
	j.setId(id);
	j.setTitle(title);
	j.setEmployer(employer);
	j.setStatus(status);
	j.setDeadline(deadline);		

	return j; 
	}

	public List<DateFormat> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<DateFormat> schedules) {
		this.schedules = schedules;
	}
	
	public void addSchedules(DateFormat date) {
		this.schedules.add(date);
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
	public void addSkill(Skill skill) {
		this.skills.add(skill);
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	
}