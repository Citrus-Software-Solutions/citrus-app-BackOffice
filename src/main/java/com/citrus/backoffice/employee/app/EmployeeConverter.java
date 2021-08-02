package com.citrus.backoffice.employee.app;

import java.util.List;

import com.citrus.backoffice.employee.domain.Employee;
import com.fasterxml.jackson.databind.JsonNode;

public interface EmployeeConverter {
	
	Employee toEmployee(JsonNode node);
	List<Employee> toEmployeeList(List<JsonNode> nodes);
	
}
