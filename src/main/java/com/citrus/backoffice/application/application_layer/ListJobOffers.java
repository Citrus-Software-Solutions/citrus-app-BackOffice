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

public class ListJobOffers {
	/*
	private static JobOffer createJobOffer (Title title, Employer employer,
										JobOfferStatus status, JobOfferDescription description,
										StartingDate startingDate, FinishingDate finishingDate) {
		JobOffer j = new JobOffer();
		j.setTitle(title);
		j.setEmployer(employer);
		j.setStatus(status);
		j.setDescription(description);
		j.setStartingDate(startingDate);
		j.setFinishingDate(finishingDate);		
		
		return j; 
	}
	*/
	
	public static List<JobOffer> listAllOffers(@Autowired RestClientService service) {
		
		List<JobOffer> offers = null;
		
		for(JsonNode i:service.getAllPosts()) {
			offers.add(JobOffer.createJobOffer( new Title(i.get("name").asText() ), 
								new Employer(new EmployerName("Banco Mercantil")),
								new JobOfferStatus( i.get("status").asText() ),
		                        new JobOfferDescription( i.get("description").asText() ),
		                        new StartingDate( i.get("date_Begin").asText() ),
		                        new FinishingDate( i.get("date_End").asText() )
		                        ));
		}
		
		/*List<JobOffer> offers = Arrays.asList( //
				JobOffer.createJobOffer( new Title("Analista de Finanzas"), 
								new Employer(new EmployerName("Banco Mercantil")),
								new JobOfferStatus("Público"),
		                        new JobOfferDescription("In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking)."),
		                        new StartingDate("08-05-2021"),
		                        new FinishingDate("15-05-2021")
		                        ),
				
				JobOffer.createJobOffer( new Title("Gerente Regional de Control de Suministros"), 
								new Employer(new EmployerName("Diageo")),
								new JobOfferStatus("Público"),
		                        new JobOfferDescription("In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking)."),
		                        new StartingDate("08-05-2021"),
		                        new FinishingDate("15-05-2021")
		                        ),
						
				JobOffer.createJobOffer( new Title("Operario de Limpieza"), 
								new Employer(new EmployerName("Frito Lay")),
								new JobOfferStatus("Oculto"),
		                        new JobOfferDescription("In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking)."),
		                        new StartingDate("08-05-2021"),
		                        new FinishingDate("15-05-2021")
		                        ),
				
				JobOffer.createJobOffer( new Title("Cosultor de Mercadeo Senior"), 
								new Employer(new EmployerName("EY Consultores")),
								new JobOfferStatus("Oculto"),
		                        new JobOfferDescription("In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking)."),
		                        new StartingDate("08-05-2021"),
		                        new FinishingDate("15-05-2021")
		                        ),
				
				JobOffer.createJobOffer( new Title("Guardia de Seguridad"), 
								new Employer(new EmployerName("Centro Polo")),
								new JobOfferStatus("Público"),
		                        new JobOfferDescription("In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking)."),
		                        new StartingDate("08-05-2021"),
		                        new FinishingDate("15-05-2021")
		                        ),
				
				JobOffer.createJobOffer( new Title("Maestro Chocolatero"), 
								new Employer(new EmployerName("Nestlé")),
								new JobOfferStatus("Oculto"),
		                        new JobOfferDescription("In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking)."),
		                        new StartingDate("08-05-2021"),
		                        new FinishingDate("15-05-2021")
		                        )
                        
        );*/

        return offers;
	}

	public static List<JobOffer> listAllOffers() {		
		List<JobOffer> offers = Arrays.asList( //
				JobOffer.createJobOffer( new Title("Analista de Finanzas"), 
								new Employer(new EmployerName("Banco Mercantil")),
								new JobOfferStatus("Público"),
		                        new JobOfferDescription("In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking)."),
		                        new StartingDate("08-05-2021"),
		                        new FinishingDate("15-05-2021")
		                        ),
				
				JobOffer.createJobOffer( new Title("Gerente Regional de Control de Suministros"), 
								new Employer(new EmployerName("Diageo")),
								new JobOfferStatus("Público"),
		                        new JobOfferDescription("In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking)."),
		                        new StartingDate("08-05-2021"),
		                        new FinishingDate("15-05-2021")
		                        ),
						
				JobOffer.createJobOffer( new Title("Operario de Limpieza"), 
								new Employer(new EmployerName("Frito Lay")),
								new JobOfferStatus("Oculto"),
		                        new JobOfferDescription("In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking)."),
		                        new StartingDate("08-05-2021"),
		                        new FinishingDate("15-05-2021")
		                        ),
				
				JobOffer.createJobOffer( new Title("Cosultor de Mercadeo Senior"), 
								new Employer(new EmployerName("EY Consultores")),
								new JobOfferStatus("Oculto"),
		                        new JobOfferDescription("In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking)."),
		                        new StartingDate("08-05-2021"),
		                        new FinishingDate("15-05-2021")
		                        ),
				
				JobOffer.createJobOffer( new Title("Guardia de Seguridad"), 
								new Employer(new EmployerName("Centro Polo")),
								new JobOfferStatus("Público"),
		                        new JobOfferDescription("In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking)."),
		                        new StartingDate("08-05-2021"),
		                        new FinishingDate("15-05-2021")
		                        ),
				
				JobOffer.createJobOffer( new Title("Maestro Chocolatero"), 
								new Employer(new EmployerName("Nestlé")),
								new JobOfferStatus("Oculto"),
		                        new JobOfferDescription("In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking)."),
		                        new StartingDate("08-05-2021"),
		                        new FinishingDate("15-05-2021")
		                        )
                        
        );

        return offers;
	}
}
