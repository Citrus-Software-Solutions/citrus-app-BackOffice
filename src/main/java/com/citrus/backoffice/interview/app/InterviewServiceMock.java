package com.citrus.backoffice.interview.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

import com.citrus.backoffice.employee.domain.Employee;
import com.citrus.backoffice.employee.domain.valueobjects.EmployeeName;
import com.citrus.backoffice.interview.domain.Interview;
import com.citrus.backoffice.interview.domain.valueobjects.InterviewAccessURL;
import com.citrus.backoffice.interview.domain.valueobjects.InterviewDuration;
import com.citrus.backoffice.interview.domain.valueobjects.InterviewId;
import com.citrus.backoffice.interview.domain.valueobjects.InterviewStatus;
import com.citrus.backoffice.shared.domain.valueobjects.DateFormat;
import com.citrus.backoffice.shared.domain.valueobjects.UserId;
import com.fasterxml.jackson.databind.JsonNode;

@SuppressWarnings("serial")
@Service
public class InterviewServiceMock implements Serializable, InterviewService{
	@Value("${PORT: 3000}")
	private String serverPort;
	
	@Override
	public List<Interview> getInterviews() {
		final String url = String.format("https://60f246b86d44f300177885e0.mockapi.io/api/Interview");
		List<Interview> interviews = new ArrayList<>();
		var converter = new InterviewConverterMock();
		
		try {
			//Fetch interviews from API
			final RequestHeadersSpec<?> spec = WebClient.create().get().uri(url);
			
			//Map results
			final List<JsonNode> nodes = spec.retrieve().toEntityList(JsonNode.class).block().getBody();
			
			//Convert to interview list
			interviews = converter.toInterviewList(nodes);
			
		} catch(Exception e) {
			//Couldn't connect to the API
			interviews.add(new Interview(
					new InterviewId(1),
					new DateFormat("9-9-1999"),
					new InterviewDuration(35),
					new InterviewAccessURL("link"),
					new InterviewStatus("Fallido"),
					new Employee(new UserId(1),
							new EmployeeName("Usuario Vacio")
					)));
		}
		return interviews;
	}

	@Override
	public Interview getInterview(long id) {
		final String url = String.format("https://60f246b86d44f300177885e0.mockapi.io/api/Interview/" + String.valueOf(id));
		var interview = new Interview();
		var converter = new InterviewConverterMock();
		
		try {
			//Fetch interviews from API
			final RequestHeadersSpec<?> spec = WebClient.create().get().uri(url);
			
			//Map results
			final JsonNode node = spec.retrieve().toEntity(JsonNode.class).block().getBody();
			
			//Convert to interview object
			interview = converter.toInterview(node);

		} catch(Exception e) {
			//Couldn't connect to the API
			interview.setId(new InterviewId(1));
			interview.setAccessURL(new InterviewAccessURL("https://www.google.com"));
			interview.setDuration(new InterviewDuration(99));
			interview.setEmployee(new Employee(new UserId(1), new EmployeeName("Usuario Vacio")));
			interview.setStartDate(new DateFormat("9-9-1999"));
			interview.setStatus(new InterviewStatus("Fallido"));
		}
		return interview;
	}
}
