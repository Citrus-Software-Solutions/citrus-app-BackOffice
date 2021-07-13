package com.citrus.backoffice.employer.domain;

import com.citrus.backoffice.employer.domain.valueobjects.EmployerName;
import com.citrus.backoffice.shared.domain.User;

public class Employer extends User {
	private EmployerName employerName;
	
	public Employer(EmployerName employerName) {
		setEmployerName(employerName);
	}

	public EmployerName getEmployerName() {
		return employerName;
	}

	public void setEmployerName(EmployerName employerName) {
		this.employerName = employerName;
	}
}
