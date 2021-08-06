package com.citrus.backoffice.application.views.employer;

import java.util.List;
import java.util.Arrays;

import com.citrus.backoffice.application.application_layer.ListJobOffers;
import com.citrus.backoffice.application.views.MainLayout;
import com.citrus.backoffice.employer.app.EmployerServiceMock;
import com.citrus.backoffice.employer.domain.Employer;
import com.citrus.backoffice.interview.domain.Interview;
import com.citrus.backoffice.joboffer.domain.JobOffer;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.UI;


@Route(value = "employer", layout = MainLayout.class)
@PageTitle("Detalles de Empleador")
public class EmployerDetailsView extends Div implements HasUrlParameter<String> {
	
	private Employer employer;
	
	@Override
	public void setParameter(BeforeEvent event, String parameter) {
		var service = new EmployerServiceMock();		
		employer = service.getEmployer(parameter);
		
	}
	
	
	private String id = "1";
	//private String company_name = employer.getEmployerName();
	private String company_name = "Empresas Polar";
	private String address = "Avenida de Los Cortijos de Lourdes, Edificio Centro Empresarial Polar. Caracas, Venezuela.";
	private String[] contacts = {"Antonio Domingues", "Gerente de Recursos Humanos", "+58 424-216 9483", "antoniod@rrhh.polar.com"};
	private String[] skills = {"hacemos cerveza", "hacemos harina", "hacemos malta", "hacemos mantequilla"};
	private String special_requirements = "Trabajo bajo presión, trabajo en Equipo, experiencia laboral en metodologías ágiles";
	private String status = "Con Vacantes";
	
	public String arrayToString (String[] myarray) {
		String list = "";
		
		for (int x=0;x<myarray.length;x++){				
				list = list + myarray[x] + ", ";
			}
		
		return list;				
	};
	
	private String skillsString = arrayToString(skills);
	
	
	public EmployerDetailsView() {

		addClassName("card-list-view");
        setSizeFull();
        
		HorizontalLayout card = new HorizontalLayout();
        card.addClassName("card");
        card.setSpacing(false);
        card.getThemeList().add("spacing-s");
        //card.add(/*image,*/ description);
        card.setHeight("100%");
        card.getStyle().set("background", "#FFFFFF");
        
        VerticalLayout description = new VerticalLayout();
        description.addClassName("description");
        description.setSpacing(false);
        description.setPadding(false);

        HorizontalLayout header = new HorizontalLayout();
        header.addClassName("header");
        header.setSpacing(false);
        header.getThemeList().add("spacing-s");

        H3 name = new H3(company_name);
        //name.addClassName("name");
        name.getStyle().set("color", "orange");
        /*
        Span ratingValue = new Span(rating);
        ratingValue.addClassName("date");*/ 
        Span spacing1 = new Span("     ");
        spacing1.addClassName("date");
        /*Icon ratingIcon = VaadinIcon.STAR.create();
        ratingIcon.addClassName("icon");*/ 
        header.add(name, spacing1/*, ratingIcon, ratingValue*/);
        
        HorizontalLayout addressLayout = new HorizontalLayout();
        addressLayout.addClassName("header");
        addressLayout.setSpacing(false);
        addressLayout.getThemeList().add("spacing-s");
        
        Icon locationIcon = VaadinIcon.MAP_MARKER.create();
        locationIcon.addClassName("icon");
        locationIcon.getStyle().set("color", "orange");
        Span locationValue = new Span(address);
        locationValue.addClassName("dates");
        
        addressLayout.add(locationIcon, locationValue);

        HorizontalLayout statusLayout = new HorizontalLayout();
        statusLayout.addClassName("actions");
        statusLayout.setSpacing(false);
        statusLayout.getThemeList().add("spacing-s");
        /*
        Icon educationLevelIcon = VaadinIcon.ACADEMY_CAP.create();
        educationLevelIcon.addClassName("icon");
        educationLevelIcon.getStyle().set("color", "orange");
        String itsEducationLevel = educationLevel + "   "; 
        Span educationLevelValue = new Span(itsEducationLevel);
        educationLevelValue.addClassName("dates");
        
        Icon phoneNumberIcon = VaadinIcon.PHONE.create();
        phoneNumberIcon.addClassName("icon");
        phoneNumberIcon.getStyle().set("color", "orange");
        String itsPhoneNumber = phoneNumber + "   "; 
        Span phoneNumberValue = new Span(itsPhoneNumber);
        phoneNumberValue.addClassName("dates");
        
        Icon dateOfBirthIcon = VaadinIcon.CALENDAR.create();
        dateOfBirthIcon.addClassName("icon");
        dateOfBirthIcon.getStyle().set("color", "orange");
        String itsDateOfBirth = "Nacimiento: " + dateOfBirth + "   "; 
        Span dateOfBirthValue = new Span(itsDateOfBirth);
        dateOfBirthValue.addClassName("dates");
        */
        Icon statusIcon = VaadinIcon.CLIPBOARD_USER.create();
        statusIcon.addClassName("icon");
        statusIcon.getStyle().set("color", "orange");
        String itsStatus = "Estatus: " + status; 
        Span statusValue = new Span(itsStatus);
        statusValue.addClassName("dates");

        statusLayout.add(/*educationLevelIcon, educationLevelValue, spacing1, phoneNumberIcon, phoneNumberValue, spacing1, dateOfBirthIcon, dateOfBirthValue, spacing1,*/ statusIcon, statusValue);
              
        VerticalLayout grids = new VerticalLayout();
        grids.addClassName("description");
        grids.setSpacing(false);
        grids.getThemeList().add("spacing-s");
        
        H5 skillsTitle = new H5("Habilidades y Competencias");
        skillsTitle.getStyle().set("color", "orange");
        Span skillsList = new Span(skillsString);
        
        H5 requirementsTitle = new H5("Requerimientos Especiales");
        requirementsTitle.getStyle().set("color", "orange");
        Span requirements = new Span(special_requirements);
        
        H5 contactTitle = new H5("Contacto");
        contactTitle.getStyle().set("color", "orange");
        Span contactName = new Span(contacts[0]);
        Span contactJob = new Span(contacts[1]);
        Span contactPhone = new Span(contacts[2]);
        Span contactEmail = new Span(contacts[3]);
        
        grids.add(skillsTitle, skillsList, requirementsTitle, requirements, contactTitle, contactName, contactJob, contactPhone, contactEmail); 
        
        description.add(header, addressLayout, statusLayout, grids);
        card.add(/*image,*/ description);
        add(card);
	}
	
	
	

}
