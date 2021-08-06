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
import com.citrus.backoffice.employee.domain.valueobjects.FirstName;
import com.citrus.backoffice.employee.domain.valueobjects.LastName;
import com.citrus.backoffice.employee.domain.valueobjects.MiddleName;
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
public class InterviewMapperSpring implements Serializable, InterviewMapper{

	@Override
	public List<Interview> getInterviews(APIPort port) {
		List<Interview> interviews = new ArrayList<>();
		
		try {
			for (JsonNode n: port.requestGetList("interview")) {
				interviews.add(new Interview(
						new InterviewId(n.get("id").asLong()),
						new DateFormat(n.get("startDate").asText()),
						new InterviewDuration(n.get("duration").asDouble()),
						new InterviewAccessURL(n.get("accessURL").asText()),
						InterviewStatusTranslator.getStatus(n.get("status").asInt()),
						new Employee(
								new UserId(n.get("employee").get("id").asLong()),
								new FirstName(n.get("employee").get("first_name").asText()),
								new MiddleName(n.get("employee").get("middle_name").asText()),
								new LastName(n.get("employee").get("last_name").asText())
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
							new FirstName("Vacio"),
							new MiddleName(""),
							new LastName("")
					)));
		}
		return interviews;
	}

	@Override
	public Interview getInterview(APIPort port, long id) {
		var interview = new Interview();
		var node = port.requestGet("interview/" + String.valueOf(id));
		
		try {
			interview.setId(new InterviewId(node.get("id").asLong()));
			interview.setAccessURL(new InterviewAccessURL(node.get("accessURL").asText()));
			interview.setDuration(new InterviewDuration(node.get("duration").asDouble()));
			interview.setEmployee(new Employee(
					new UserId(node.get("employee").get("id").asLong()),
					new FirstName(node.get("employee").get("first_name").asText()),
					new MiddleName(node.get("employee").get("middle_name").asText()),
					new LastName(node.get("employee").get("last_name").asText())));
			interview.setStartDate(new DateFormat(node.get("startDate").asText()));
			interview.setStatus(InterviewStatusTranslator.getStatus(node.get("status").asInt()));
		} catch (Exception e) {
			interview.setId(new InterviewId(404));
			interview.setAccessURL(new InterviewAccessURL("about:blank"));
			interview.setDuration(new InterviewDuration(0.0));
			interview.setEmployee(new Employee(
					new UserId(404),
					new FirstName("Vacio"),
					new MiddleName(""),
					new LastName("")));
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
