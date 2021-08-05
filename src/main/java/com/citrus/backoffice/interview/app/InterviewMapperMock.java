package com.citrus.backoffice.interview.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class InterviewMapperMock implements Serializable, InterviewMapper{

	@Override
	public List<Interview> getInterviews(APIPort port) {
		List<Interview> interviews = new ArrayList<>();
		
		try {
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
		} catch (Exception e) {
			interviews.add(new Interview(
					new InterviewId(404),
					new DateFormat("0/0/0000"),
					new InterviewDuration(0.0),
					new InterviewAccessURL("about:blank"),
					new InterviewStatus("Fallido"),
					new Employee(
							new UserId(404),
							new EmployeeName("Vacio")
					)));
		}
		return interviews;
	}

	@Override
	public Interview getInterview(APIPort port, long id) {
		var interview = new Interview();
		var node = port.requestGet("Interview/" + String.valueOf(id));
		
		try {
			interview.setId(new InterviewId(node.get("id").asLong()));
			interview.setAccessURL(new InterviewAccessURL(node.get("access_url").asText()));
			interview.setDuration(new InterviewDuration(node.get("duration").asDouble()));
			interview.setEmployee(new Employee(
					new UserId(node.get("employee").get("id").asLong()),
					new EmployeeName(node.get("employee").get("full_name").asText())));
			interview.setStartDate(new DateFormat(node.get("date").asText()));
			interview.setStatus(new InterviewStatus(node.get("status").asText()));
		} catch (Exception e) {
			interview.setId(new InterviewId(404));
			interview.setAccessURL(new InterviewAccessURL("about:blank"));
			interview.setDuration(new InterviewDuration(0.0));
			interview.setEmployee(new Employee(
					new UserId(404),
					new EmployeeName("Vacio")));
			interview.setStartDate(new DateFormat("0/0/0000"));
			interview.setStatus(new InterviewStatus("Fallido"));
		}
		
		return interview;
	}

	@Override
	public void rescheduleInterview(APIPort port, String date, Interview interview) {
		interview.setStartDate(new DateFormat(date));
		port.requestPut("Interview/" + String.valueOf(interview.getId().getValue()), interview);
	}
	
}
