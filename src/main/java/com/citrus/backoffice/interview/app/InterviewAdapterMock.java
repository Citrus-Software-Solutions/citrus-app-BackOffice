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
import com.citrus.backoffice.shared.ports.APIPort;
import com.fasterxml.jackson.databind.JsonNode;

@SuppressWarnings("serial")
@Service
public class InterviewAdapterMock implements Serializable, InterviewAdapter{

	@Override
	public List<Interview> getInterviews(APIPort port) {
		List<Interview> interviews = new ArrayList<>();
		
		for (JsonNode n: port.requestGetList("Interview")) {
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
		
		return interviews;
	}

	@Override
	public Interview getInterview(APIPort port, long id) {
		var interview = new Interview();
		var node = port.requestGet("Interview/" + String.valueOf(id));
		
		interview.setId(new InterviewId(node.get("id").asLong()));
		interview.setAccessURL(new InterviewAccessURL(node.get("access_url").asText()));
		interview.setDuration(new InterviewDuration(node.get("duration").asDouble()));
		interview.setEmployee(new Employee(
				new UserId(node.get("employee").get("id").asLong()),
				new EmployeeName(node.get("employee").get("full_name").asText())));
		interview.setStartDate(new DateFormat(node.get("date").asText()));
		interview.setStatus(new InterviewStatus(node.get("status").asText()));
		
		return interview;
	}
	
}
