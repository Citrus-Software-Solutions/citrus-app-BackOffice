package com.citrus.backoffice.jobapplication.app;

import java.util.List;

import com.citrus.backoffice.interview.domain.Interview;
import com.citrus.backoffice.jobapplication.domain.JobApplication;
import com.citrus.backoffice.shared.ports.APIPort;

public interface JobApplicationMapper {

	List<JobApplication> getApplications(APIPort port);
	JobApplication getApplication(APIPort port, long id);
	
}
