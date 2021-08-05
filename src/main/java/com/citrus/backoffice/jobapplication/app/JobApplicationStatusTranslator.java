package com.citrus.backoffice.jobapplication.app;

import com.citrus.backoffice.jobapplication.domain.valueobjects.ApplicationStatus;
import com.citrus.backoffice.joboffer.domain.valueobjects.JobOfferStatus;

public class JobApplicationStatusTranslator {
	
	public static ApplicationStatus getStatus(int i) {
		var result = new String();
		switch (i) {
			case 1: {
				result = "Aceptado";
				break;
			}
			case 2: {
				result = "Rechazado";
				break;
			}
			default: {
				result = "Revision Pendiente";
				break;
			}
		}
		return new ApplicationStatus(result);
	}
	
}
