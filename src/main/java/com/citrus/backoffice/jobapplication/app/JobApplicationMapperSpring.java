package com.citrus.backoffice.jobapplication.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.citrus.backoffice.employee.domain.Employee;
import com.citrus.backoffice.employee.domain.valueobjects.FirstName;
import com.citrus.backoffice.employee.domain.valueobjects.LastName;
import com.citrus.backoffice.employee.domain.valueobjects.MiddleName;
import com.citrus.backoffice.interview.domain.Interview;
import com.citrus.backoffice.jobapplication.domain.JobApplication;
import com.citrus.backoffice.jobapplication.domain.valueobjects.ApplicationDate;
import com.citrus.backoffice.jobapplication.domain.valueobjects.ApplicationId;
import com.citrus.backoffice.jobapplication.domain.valueobjects.ApplicationStatus;
import com.citrus.backoffice.joboffer.domain.JobOffer;
import com.citrus.backoffice.joboffer.domain.valueobjects.JobOfferId;
import com.citrus.backoffice.joboffer.domain.valueobjects.Title;
import com.citrus.backoffice.shared.domain.valueobjects.DateFormat;
import com.citrus.backoffice.shared.domain.valueobjects.UserId;
import com.citrus.backoffice.shared.ports.APIPort;
import com.fasterxml.jackson.databind.JsonNode;

public class JobApplicationMapperSpring implements JobApplicationMapper {

	@Override
	public List<JobApplication> getApplications(APIPort port) {
		List<JobApplication> applications = new ArrayList<>();
		
		for (JsonNode n: port.requestGetList("job-application")) {
			applications.add(JobApplication.createApplication(
					new ApplicationId(n.get("id").asLong()),
					new DateFormat(n.get("application_Date").asText()),
					new Employee(
							new UserId(n.get("employee").get("id").asLong()),
							new FirstName(n.get("employee").get("first_name").asText()),
							new MiddleName(n.get("employee").get("middle_name").asText()),
							new LastName(n.get("employee").get("last_name").asText())),
					new JobOffer(
							new JobOfferId(n.get("jobOffer").get("id").asLong()),
							new Title(n.get("jobOffer").get("title").asText())),
					JobApplicationStatusTranslator.getStatus(n.get("status").asInt())));
		}
		
		return applications;
	}

	@Override
	public JobApplication getApplication(APIPort port, long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
