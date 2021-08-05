package com.citrus.backoffice.employee.app;

import java.util.Date;
import java.util.List;

import com.citrus.backoffice.employee.domain.Employee;
import com.citrus.backoffice.employee.domain.valueobjects.BirthDate;
import com.citrus.backoffice.shared.domain.valueobjects.UserId;
import com.fasterxml.jackson.databind.JsonNode;

public class EmployeeConverterSpring implements EmployeeConverter {

	@Override
	public Employee toEmployee(JsonNode node) {
		var employee = new Employee(new UserId(node.get("id").asLong()));
		
		employee.setBirthDate(null);
		employee.setDocument(null);
		employee.setEmail(null);
		employee.setFullName(null);
		employee.setGender(null);
		employee.setLocation(null);
		employee.setName(null);
		
		return null;
	}

	@Override
	public List<Employee> toEmployeeList(List<JsonNode> nodes) {
		// TODO Auto-generated method stub
		return null;
	}

}
