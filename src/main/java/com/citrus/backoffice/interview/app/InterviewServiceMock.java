package com.citrus.backoffice.interview.app;

import java.io.Serializable;
import java.util.ArrayList;
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
		List<Interview> interviews = new ArrayList<>(); ;
		
		try {
			//Fetch interviews from API
			final RequestHeadersSpec<?> spec = WebClient.create().get().uri(url);
			
			//Map results
			final List<JsonNode> nodes = spec.retrieve().toEntityList(JsonNode.class).block().getBody();
			
			for (JsonNode n: nodes) {
				interviews.add(new Interview(
						new InterviewId(n.get("id").asLong()),
						new DateFormat(n.get("startDate").asText()),
						new InterviewDuration(n.get("duration").asDouble()),
						new InterviewAccessURL(n.get("accessUrl").asText()),
						new InterviewStatus(n.get("status").asText()),
						new Employee(new UserId(n.get("employeeId").asLong())
						)));
			}		
		} catch(Exception e) {
			//Couldn't connect to the API
		}
		return interviews;
	}
}
