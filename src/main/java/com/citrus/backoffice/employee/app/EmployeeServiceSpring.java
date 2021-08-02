package com.citrus.backoffice.employee.app;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

import com.citrus.backoffice.employee.domain.Employee;
import com.citrus.backoffice.shared.domain.valueobjects.UserId;
import com.fasterxml.jackson.databind.JsonNode;

public class EmployeeServiceSpring implements EmployeeService {

	@Override
	public Employee getEmployee(long id) {
		final String url = String.format("https://localhost:3000/Employee/" + String.valueOf(id));
		var employee = new Employee(new UserId(id));
		
		
		try {
			//Fetch employees from API
			final RequestHeadersSpec<?> spec = WebClient.create().get().uri(url);
			
			//Map results
			final JsonNode node = spec.retrieve().toEntity(JsonNode.class).block().getBody();
			
			//Convert to employee object
			
		} catch (Exception e) {
			
		}
		
		return employee;
	}

}
