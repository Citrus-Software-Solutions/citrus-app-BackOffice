package com.citrus.backoffice.interview.app;

import com.citrus.backoffice.interview.domain.valueobjects.InterviewStatus;

public class InterviewStatusTranslator {
	
	public static InterviewStatus getStatus(int i) {
		var result = new String();
		switch (i) {
			case 1: {
				result = "Agendada";
				break;
			}
			case 2: {
				result = "Aprovada";
				break;
			}
			case 3: {
				result = "Rechazada";
				break;
			}
			default: {
				result = "Creada";
				break;
			}
		}
		return new InterviewStatus(result);
	}
	
}
