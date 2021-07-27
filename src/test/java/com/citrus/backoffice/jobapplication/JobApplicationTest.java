package com.citrus.backoffice.jobapplication;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.citrus.backoffice.jobapplication.app.JobApplicationService;
import com.citrus.backoffice.jobapplication.app.JobApplicationServiceMock;

public class JobApplicationTest {
	@Test
	public void getApplications() {
		JobApplicationService service = new JobApplicationServiceMock();
		
		System.out.println(service.getApplications());
		
		assertNotNull(service);
	}
}
