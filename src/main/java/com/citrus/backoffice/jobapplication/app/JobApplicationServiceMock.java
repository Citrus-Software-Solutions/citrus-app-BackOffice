package com.citrus.backoffice.jobapplication.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

import com.citrus.backoffice.employee.domain.Employee;
import com.citrus.backoffice.interview.domain.Interview;
import com.citrus.backoffice.interview.domain.valueobjects.InterviewAccessURL;
import com.citrus.backoffice.interview.domain.valueobjects.InterviewDuration;
import com.citrus.backoffice.interview.domain.valueobjects.InterviewId;
import com.citrus.backoffice.interview.domain.valueobjects.InterviewStatus;
import com.citrus.backoffice.jobapplication.domain.JobApplication;
import com.citrus.backoffice.jobapplication.domain.valueobjects.ApplicationDate;
import com.citrus.backoffice.jobapplication.domain.valueobjects.ApplicationId;
import com.citrus.backoffice.jobapplication.domain.valueobjects.ApplicationStatus;
import com.citrus.backoffice.joboffer.domain.JobOffer;
import com.citrus.backoffice.joboffer.domain.valueobjects.JobOfferId;
import com.citrus.backoffice.joboffer.domain.valueobjects.Title;
import com.citrus.backoffice.shared.domain.valueobjects.DateFormat;
import com.citrus.backoffice.shared.domain.valueobjects.UserId;
import com.fasterxml.jackson.databind.JsonNode;

@SuppressWarnings("serial")
@Service
public class JobApplicationServiceMock implements JobApplicationService {

	@Value("${PORT: 3000}")
	private String serverPort;
	
	@Override
	public List<JobApplication> getApplications() {		
		final String url = String.format("https://60f246b86d44f300177885e0.mockapi.io/api/JobApplication");
		List<JobApplication> applications = new ArrayList<>();
		
		try {
			//Fetch interviews from API
			final RequestHeadersSpec<?> spec = WebClient.create().get().uri(url);
			
			//Map results
			final List<JsonNode> nodes = spec.retrieve().toEntityList(JsonNode.class).block().getBody();
			
			for (JsonNode n: nodes) {
				applications.add(JobApplication.createApplication(
						new ApplicationId(n.get("id").asLong()),
						new ApplicationDate(new Date(n.get("date").asLong())),
						new Employee(new UserId(n.get("employee").get("id").asLong())),
						new JobOffer(new JobOfferId(n.get("job_offer").get("id").asLong()),
								new Title(n.get("job_offer").get("title").asText())),
						new ApplicationStatus(n.get("status").asInt())));
			}		
		} catch(Exception e) {
			//Couldn't connect to the API
		}
		
		return applications;
	}

}
