package com.citrus.backoffice.jobapplication.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.citrus.backoffice.employee.domain.Employee;
import com.citrus.backoffice.interview.domain.Interview;
import com.citrus.backoffice.jobapplication.domain.JobApplication;
import com.citrus.backoffice.jobapplication.domain.valueobjects.ApplicationDate;
import com.citrus.backoffice.jobapplication.domain.valueobjects.ApplicationId;
import com.citrus.backoffice.jobapplication.domain.valueobjects.ApplicationStatus;
import com.citrus.backoffice.joboffer.domain.JobOffer;
import com.citrus.backoffice.joboffer.domain.valueobjects.JobOfferId;
import com.citrus.backoffice.joboffer.domain.valueobjects.Title;
import com.citrus.backoffice.shared.domain.valueobjects.UserId;
import com.citrus.backoffice.shared.ports.APIPort;
import com.fasterxml.jackson.databind.JsonNode;

public class JobApplicationMapperMock implements JobApplicationMapper {

	@Override
	public List<JobApplication> getApplications(APIPort port) {
		List<JobApplication> applications = new ArrayList<>();
		
		for (JsonNode n: port.requestGetList("JobApplication")) {
			applications.add(JobApplication.createApplication(
					new ApplicationId(n.get("id").asLong()),
					new ApplicationDate(new Date(n.get("date").asLong())),
					new Employee(new FullName(n.get("employee").get("id").asLong())),
					new JobOffer(new JobOfferId(n.get("job_offer").get("id").asLong()),
							new Title(n.get("job_offer").get("title").asText())),
					new ApplicationStatus(n.get("status").asInt())));
		}
		
		return applications;
	}

	@Override
	public JobApplication getApplication(APIPort port, long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
