package com.citrus.backoffice.interview.app;

import java.util.List;

import com.citrus.backoffice.interview.domain.Interview;
import com.citrus.backoffice.shared.ports.APIPort;

public interface InterviewAdapter {

	List<Interview> getInterviews(APIPort port);
	Interview getInterview(APIPort port, long id);
	
}
