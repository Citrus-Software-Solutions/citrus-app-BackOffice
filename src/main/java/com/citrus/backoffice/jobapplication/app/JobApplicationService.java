package com.citrus.backoffice.jobapplication.app;

import java.util.List;

import com.citrus.backoffice.jobapplication.domain.JobApplication;

public interface JobApplicationService {

	List<JobApplication> getApplications();
	
}
