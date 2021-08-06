package com.citrus.backoffice.application.application_layer;

import java.util.Arrays;
import java.util.List;

import com.citrus.backoffice.employer.domain.Employer;
import com.citrus.backoffice.employer.domain.valueobjects.EmployerName;
import com.citrus.backoffice.joboffer.domain.JobOffer;
import com.citrus.backoffice.joboffer.domain.valueobjects.Deadline;
import com.citrus.backoffice.joboffer.domain.valueobjects.JobOfferId;
import com.citrus.backoffice.joboffer.domain.valueobjects.JobOfferStatus;
import com.citrus.backoffice.joboffer.domain.valueobjects.Title;

public class ListEmployersOffers {
	
	public static List<JobOffer> listAllEmployersOffers() {		
		List<JobOffer> offers = Arrays.asList( //
				JobOffer.createJobOffer( new JobOfferId(1), new Title("Analista de Finanzas"), 
								new Employer(new EmployerName("Nestlé de Venezuela C.A.")),
								new JobOfferStatus("Público"),
		                        new Deadline("15-05-2021")
		                        ),
				
				JobOffer.createJobOffer( new JobOfferId(1), new Title("Gerente Regional de Control de Suministros"), 
								new Employer(new EmployerName("Nestlé de Venezuela C.A.")),
								new JobOfferStatus("Público"),
		                        new Deadline("15-05-2021")
		                        ),
						
				JobOffer.createJobOffer( new JobOfferId(1), new Title("Operario de Limpieza"), 
								new Employer(new EmployerName("Nestlé de Venezuela C.A.")),
								new JobOfferStatus("Oculto"),
		                        new Deadline("15-05-2021")
		                        ),
				
				JobOffer.createJobOffer( new JobOfferId(1), new Title("Cosultor de Mercadeo Senior"), 
								new Employer(new EmployerName("Nestlé de Venezuela C.A.")),
								new JobOfferStatus("Oculto"),
		                        new Deadline("15-05-2021")
		                        ),
				
				JobOffer.createJobOffer( new JobOfferId(1), new Title("Guardia de Seguridad"), 
								new Employer(new EmployerName("Nestlé de Venezuela C.A.")),
								new JobOfferStatus("Público"),
		                        new Deadline("15-05-2021")
		                        ),
				
				JobOffer.createJobOffer( new JobOfferId(1), new Title("Maestro Chocolatero"), 
								new Employer(new EmployerName("Nestlé de Venezuela C.A.")),
								new JobOfferStatus("Oculto"),
		                        new Deadline("15-05-2021")
		                        )
                        
        );

        return offers;
	}

}
