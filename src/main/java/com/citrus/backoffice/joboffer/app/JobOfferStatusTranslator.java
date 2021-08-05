package com.citrus.backoffice.joboffer.app;

import com.citrus.backoffice.joboffer.domain.valueobjects.JobOfferStatus;

public class JobOfferStatusTranslator {
	
	public static JobOfferStatus getStatus(int i) {
		var result = new String();
		switch (i) {
			case 1: {
				result = "Aplicaciones Abiertas";
				break;
			}
			case 2: {
				result = "Aplicaciones Cerradas";
				break;
			}
			case 3: {
				result = "Asignado";
				break;
			}
			case 4: {
				result = "En Progreso";
				break;
			}
			case 5: {
				result = "Terminado";
				break;
			}
			case 6: {
				result = "Cancelado";
				break;
			}
			default: {
				result = "Creado";
				break;
			}
		}
		return new JobOfferStatus(result);
	}
	
}
