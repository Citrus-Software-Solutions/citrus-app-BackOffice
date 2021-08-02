package com.citrus.backoffice.interview.app;

import java.util.ArrayList;
import java.util.List;

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

public class InterviewConverterMock implements InterviewConverter {

	@Override
	public Interview toInterview(JsonNode node) {
		var interview = new Interview();
		
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

	@Override
	public JsonNode toJsonNode(Interview interview) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Interview> toInterviewList(List<JsonNode> nodes) {
		List<Interview> interviews = new ArrayList<>();
		
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
		
		return interviews;
	}

	@Override
	public List<JsonNode> toJsonNodeList(List<Interview> interviews) {
		// TODO Auto-generated method stub
		return null;
	}

}
