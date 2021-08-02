package com.citrus.backoffice.interview.infraestructure;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import com.citrus.backoffice.interview.domain.valueobjects.InterviewId;

public class InterviewUpdaterMock implements InterviewUpdater {

	@Override
	public void updateStatus(InterviewId id, String status) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateDate(InterviewId id, String date) {
		final String url = String.format("https://60f246b86d44f300177885e0.mockapi.io/api/Interview/" + String.valueOf(id) + "");
		
		try {
			//Fetch interviews from API
			final ResponseSpec spec = WebClient
					.create()
					.patch()
					.uri(url)
					.attribute("date", date)
					.retrieve();
		} catch (Exception e) {
			
		}
	}

}
