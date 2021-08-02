package com.citrus.backoffice.interview.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
import com.citrus.backoffice.jobapplication.domain.JobApplication;
import com.citrus.backoffice.shared.domain.valueobjects.DateFormat;
import com.citrus.backoffice.shared.domain.valueobjects.Document;
import com.citrus.backoffice.shared.domain.valueobjects.UserId;
import com.citrus.backoffice.shared.domain.valueobjects.Username;
import com.citrus.backoffice.staffmember.domain.StaffMember;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.example.rest.data.DataDTO;

@SuppressWarnings("serial")
@Service
public class InterviewServiceSpring implements Serializable, InterviewService{
	@Value("${PORT: 3000}")
	private String serverPort;
	
	@Override
	public List<Interview> getInterviews() {
		final String url = String.format("https://60f246b86d44f300177885e0.mockapi.io/api/Interview");
		List<Interview> interviews = new ArrayList<>();
		
		try {
			//Fetch interviews from API
			final RequestHeadersSpec<?> spec = WebClient.create().get().uri(url);
			
			//Map results
			final List<JsonNode> nodes = spec.retrieve().toEntityList(JsonNode.class).block().getBody();
			
			for (JsonNode n: nodes) {
				interviews.add(new Interview(
						new InterviewId(n.get("id").asLong()),
						new DateFormat(n.get("date").asText()),
						new InterviewDuration(n.get("duration").asDouble()),
						new InterviewAccessURL(n.get("access_url").asText()),
						new InterviewStatus(n.get("status").asText()),
						new Employee(
								new UserId(n.get("employee").get("id").asLong()),
								new EmployeeName(n.get("employee").get("full_name").asText())
						)));
			}
		} catch(Exception e) {
			//Couldn't connect to the API
			interviews.add(new Interview(
					new InterviewId(1),
					new DateFormat("9-9-1999"),
					new InterviewDuration(35),
					new InterviewAccessURL("link"),
					new InterviewStatus("Fallido"),
					new Employee(new UserId(1),
							new EmployeeName("Lopez")
					)));
		}
		return interviews;
	}

	@Override
	public Interview getInterview(long id) {
		final String url = String.format("https://60f246b86d44f300177885e0.mockapi.io/api/Interview/" + String.valueOf(id));
		var interview = new Interview();
		
		try {
			//Fetch interviews from API
			final RequestHeadersSpec<?> spec = WebClient.create().get().uri(url);
			
			//Map results
			final JsonNode node = spec.retrieve().toEntity(JsonNode.class).block().getBody();
			
			interview.setId(new InterviewId(id));
			interview.setAccessURL(new InterviewAccessURL(node.get("access_url").asText()));
			interview.setDuration(new InterviewDuration(node.get("duration").asDouble()));
			interview.setEmployee(new Employee(
					new UserId(node.get("employee").get("id").asLong()),
					new EmployeeName(node.get("employee").get("full_name").asText())));
			interview.setStartDate(new DateFormat(node.get("date").asText()));
			interview.setStatus(new InterviewStatus(node.get("status").asText()));

		} catch(Exception e) {
			//Couldn't connect to the API
			interview.setId(new InterviewId(1));
			interview.setAccessURL(new InterviewAccessURL("https://www.google.com"));
			interview.setDuration(new InterviewDuration(35));
			interview.setEmployee(new Employee(new UserId(16)));
			interview.setStartDate(new DateFormat("9-9-1999"));
			interview.setStatus(new InterviewStatus("Agendada"));
		}
		return interview;
	}
}
