package com.citrus.backoffice.application.application_layer;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.citrus.backoffice.employer.domain.Employer;
import com.citrus.backoffice.employer.domain.valueobjects.EmployerName;
import com.citrus.backoffice.joboffer.domain.JobOffer;
import com.citrus.backoffice.joboffer.domain.valueobjects.FinishingDate;
import com.citrus.backoffice.joboffer.domain.valueobjects.JobOfferDescription;
import com.citrus.backoffice.joboffer.domain.valueobjects.JobOfferStatus;
import com.citrus.backoffice.joboffer.domain.valueobjects.StartingDate;
import com.citrus.backoffice.joboffer.domain.valueobjects.Title;
import com.fasterxml.jackson.databind.JsonNode;
import com.vaadin.example.rest.data.RestClientService;

public class ListEmployersOffers {
	
	public static List<JobOffer> listAllEmployersOffers() {		
		List<JobOffer> offers = Arrays.asList( //
				JobOffer.createJobOffer( new Title("Analista de Finanzas"), 
								new Employer(new EmployerName("Nestlé de Venezuela C.A.")),
								new JobOfferStatus("Público"),
		                        new JobOfferDescription("In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking)."),
		                        new StartingDate("Valencia"),
		                        new FinishingDate("15-05-2021")
		                        ),
				
				JobOffer.createJobOffer( new Title("Gerente Regional de Control de Suministros"), 
								new Employer(new EmployerName("Nestlé de Venezuela C.A.")),
								new JobOfferStatus("Público"),
		                        new JobOfferDescription("In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking)."),
		                        new StartingDate("Caracas"),
		                        new FinishingDate("15-05-2021")
		                        ),
						
				JobOffer.createJobOffer( new Title("Operario de Limpieza"), 
								new Employer(new EmployerName("Nestlé de Venezuela C.A.")),
								new JobOfferStatus("Oculto"),
		                        new JobOfferDescription("In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking)."),
		                        new StartingDate("Mérida"),
		                        new FinishingDate("15-05-2021")
		                        ),
				
				JobOffer.createJobOffer( new Title("Cosultor de Mercadeo Senior"), 
								new Employer(new EmployerName("Nestlé de Venezuela C.A.")),
								new JobOfferStatus("Oculto"),
		                        new JobOfferDescription("In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking)."),
		                        new StartingDate("Puerto Ordaz"),
		                        new FinishingDate("15-05-2021")
		                        ),
				
				JobOffer.createJobOffer( new Title("Guardia de Seguridad"), 
								new Employer(new EmployerName("Nestlé de Venezuela C.A.")),
								new JobOfferStatus("Público"),
		                        new JobOfferDescription("In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking)."),
		                        new StartingDate("Maracaibo"),
		                        new FinishingDate("15-05-2021")
		                        ),
				
				JobOffer.createJobOffer( new Title("Maestro Chocolatero"), 
								new Employer(new EmployerName("Nestlé de Venezuela C.A.")),
								new JobOfferStatus("Oculto"),
		                        new JobOfferDescription("In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking)."),
		                        new StartingDate("San Cristobal"),
		                        new FinishingDate("15-05-2021")
		                        )
                        
        );

        return offers;
	}

}
