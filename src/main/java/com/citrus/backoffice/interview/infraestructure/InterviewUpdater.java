package com.citrus.backoffice.interview.infraestructure;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.citrus.backoffice.interview.domain.valueobjects.InterviewId;

public interface InterviewUpdater {

	public void updateStatus(@PathVariable("id") InterviewId id, @RequestParam String status);
	public void updateDate(@PathVariable("id")InterviewId id, @RequestParam String date);
	
}
