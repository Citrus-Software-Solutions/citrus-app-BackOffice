package com.citrus.backoffice.jobapplication.domain;

import com.citrus.backoffice.employee.domain.Employee;
import com.citrus.backoffice.jobapplication.domain.valueobjects.ApplicationDate;
import com.citrus.backoffice.jobapplication.domain.valueobjects.ApplicationId;
import com.citrus.backoffice.jobapplication.domain.valueobjects.ApplicationStatus;
import com.citrus.backoffice.joboffer.domain.JobOffer;

public class JobApplication {
	ApplicationId id;
	ApplicationDate date;
	Employee employee;
	JobOffer jobOffer;
	ApplicationStatus status;
	
	public JobApplication(ApplicationId id) {
		this.id = id;
	}

	public ApplicationId getId() {
		return id;
	}
	
	public void setId(ApplicationId id) {
		this.id = id;
	}
	
	public ApplicationDate getDate() {
		return date;
	}
	
	public void setDate(ApplicationDate date) {
		this.date = date;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public JobOffer getJobOffer() {
		return jobOffer;
	}
	
	public void setJobOffer(JobOffer jobOffer) {
		this.jobOffer = jobOffer;
	}
	
	public ApplicationStatus getStatus() {
		return status;
	}
	
	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}
}
