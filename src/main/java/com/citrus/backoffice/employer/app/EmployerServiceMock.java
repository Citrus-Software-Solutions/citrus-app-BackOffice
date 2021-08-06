package com.citrus.backoffice.employer.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

import com.citrus.backoffice.employee.domain.Employee;
import com.citrus.backoffice.interview.app.InterviewService;
import com.citrus.backoffice.employer.domain.Employer;
import com.citrus.backoffice.shared.domain.valueobjects.DateFormat;
import com.citrus.backoffice.shared.domain.valueobjects.UserId;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Arrays;
import java.util.regex.Pattern;

@SuppressWarnings("serial")
@Service
public class EmployerServiceMock implements Serializable, EmployerService{
	@Value("${PORT: 3000}")
	private String serverPort;
	
	@Override
	public Employer getEmployer(String id) {
		final String url = String.format("https://60f96c96ee56ef0017975dcb.mockapi.io/employer/" + id);
		//List<Interview> interviews = new ArrayList<>(); 
		Employer employer = null;
		
		try {
			//Fetch interviews from API
			final RequestHeadersSpec<?> spec = WebClient.create().get().uri(url);
			
			//Map results
			final List<JsonNode> nodes = spec.retrieve().toEntityList(JsonNode.class).block().getBody();
			
			for (JsonNode n: nodes) {
				
				String contactsString = n.get("contacts").toString();
				String skillsString = n.get("skills").toString();				
				String[] contactsArray = contactsString.split(",");				
				String[] skillsArray = skillsString.split(",");
				
				employer = new Employer(
						n.get("id").toString(),
						n.get("company_name").toString(),
						n.get("address").toString(),
						contactsArray,
						skillsArray,
						n.get("special_requirements").toString(),
						n.get("status").toString()
						);
			}		
		} catch(Exception e) {
			//Couldn't connect to the API
		}
		return employer;
	}

}
