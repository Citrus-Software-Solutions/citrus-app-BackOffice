package com.citrus.backoffice.interview.domain;

import javax.persistence.Entity;

import com.citrus.backoffice.employee.domain.Employee;
import com.citrus.backoffice.interview.domain.valueobjects.InterviewAccessURL;
import com.citrus.backoffice.interview.domain.valueobjects.InterviewDuration;
import com.citrus.backoffice.interview.domain.valueobjects.InterviewId;
import com.citrus.backoffice.interview.domain.valueobjects.InterviewStatus;
import com.citrus.backoffice.shared.domain.valueobjects.DateFormat;

@Entity
public class Interview {
	InterviewId id;
	Employee employee;
	DateFormat startDate;
	InterviewDuration duration;
	InterviewAccessURL accessURL;
	InterviewStatus status;
	
	public Interview(InterviewId id,
			DateFormat date,
			InterviewDuration duration,
			InterviewAccessURL accessURL,
			InterviewStatus status,
			Employee employee) {
		this.id = id;
		startDate = date;
		this.duration = duration;
		this.accessURL = accessURL;
		this.status = status;
		this.employee = employee;
	}
	
	public InterviewId getId() {
		return id;
	}
	
	public void setId(InterviewId id) {
		this.id = id;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public DateFormat getStartDate() {
		return startDate;
	}
	
	public void setStartDate(DateFormat startDate) {
		this.startDate = startDate;
	}
	
	public InterviewDuration getDuration() {
		return duration;
	}
	
	public void setDuration(InterviewDuration duration) {
		this.duration = duration;
	}
	
	public InterviewAccessURL getAccessURL() {
		return accessURL;
	}
	
	public void setAccessURL(InterviewAccessURL accessURL) {
		this.accessURL = accessURL;
	}
	
	public InterviewStatus getStatus() {
		return status;
	}
	
	public void setStatus(InterviewStatus status) {
		this.status = status;
	}
}
