package com.citrus.backoffice.application.views.applicant;

import com.citrus.backoffice.application.views.MainLayout;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "applicant", layout = MainLayout.class)
@PageTitle("Detalles de Aplicante")
public class ApplicantDetailsView extends Div implements HasUrlParameter<String>{

	private String firstName = "Pedro";
	private String middleName = "Alejandro";
	private String LastName = "Pérez";
	private String phoneNumber = "+58 424-2458027";
	private String dateOfBirth = "07/02/1997";
	private String address = "Urb. Los Geranios, El Hatillo. Caracas, Venezuela";
	private String educationLevel = "Ingeniero de Informática";
	private String rating = "4.5";
	private String status = "Desempleado";
	private String[] workExperience = {"Microsoft", "Banesco", "Laboratorio Vincentin"};
	private String[] skills = {"Nivel Intermedio de Python", "Front-end en React", "Administración de Bases de Datos"};
	private String[] references = {"María Alejandra", "Jesús Farías", "Roberto Mata"};
    private Button schedule = new Button("Agendar entrevista");
    private Button back = new Button("Regresar", e -> UI.getCurrent().navigate(ApplicantListView.class));  
    
	public String arrayToString (String[] myarray) {
		String list = "";
		for (int x=0;x<myarray.length;x++){				
				list = list + myarray[x] + ", ";
			}
		
		return list;
				
	};
	
	String workExperienceString = arrayToString(workExperience);
	String skillsString = arrayToString(skills);
	String referencesString = arrayToString(references); 
	
	public ApplicantDetailsView() {
		addClassName("card-list-view");
        setSizeFull();
        
		HorizontalLayout card = new HorizontalLayout();
        card.addClassName("card");
        card.setSpacing(false);
        card.getThemeList().add("spacing-s");
        
        VerticalLayout description = new VerticalLayout();
        description.addClassName("description");
        description.setSpacing(false);
        description.setPadding(false);

        HorizontalLayout header = new HorizontalLayout();
        header.addClassName("header");
        header.setSpacing(false);
        header.getThemeList().add("spacing-s");

        String fullTitle = firstName + " " + middleName + " " +  LastName;
        H3 name = new H3(fullTitle);
        name.getStyle().set("color", "orange");
        
        Span ratingValue = new Span(rating);
        ratingValue.addClassName("date"); 
        Span spacing1 = new Span("     ");
        spacing1.addClassName("date");
        Icon ratingIcon = VaadinIcon.STAR.create();
        ratingIcon.addClassName("icon"); 
        header.add(name, spacing1, ratingIcon, ratingValue);

        HorizontalLayout info = new HorizontalLayout();
        info.addClassName("actions");
        info.setSpacing(false);
        info.getThemeList().add("spacing-s");
        
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
        
        Icon statusIcon = VaadinIcon.CLIPBOARD_USER.create();
        statusIcon.addClassName("icon");
        statusIcon.getStyle().set("color", "orange");
        String itsStatus = "Estatus: " + status; 
        Span statusValue = new Span(itsStatus);
        statusValue.addClassName("dates");

        info.add(educationLevelIcon, educationLevelValue, spacing1, phoneNumberIcon, phoneNumberValue, spacing1, dateOfBirthIcon, dateOfBirthValue, spacing1, statusIcon, statusValue);
        
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
        
        VerticalLayout grids = new VerticalLayout();
        grids.addClassName("description");
        grids.setSpacing(false);
        grids.getThemeList().add("spacing-s");
        
        H5 experienceTitle = new H5("Experiencia de Trabajo");
        experienceTitle.getStyle().set("color", "orange");
        Span primervalor = new Span(workExperienceString);
        H5 skillsTitle = new H5("Habilidades y Competencias");
        skillsTitle.getStyle().set("color", "orange");
        Span segundovalor = new Span(skillsString);
        H5 referencesTitle = new H5("Referencias");
        referencesTitle.getStyle().set("color", "orange");
        Span tercervalor = new Span(referencesString);
        
        grids.add(experienceTitle, primervalor, skillsTitle, segundovalor, referencesTitle, tercervalor/*, workExperienceGrid, skillsGrid, referencesGrid*/);        
        
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        schedule.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(back, schedule);
        
        VerticalLayout buttonAlign = new VerticalLayout();
        buttonAlign.setWidth("90%");
        buttonAlign.setAlignItems(Alignment.END); 
        buttonAlign.add(buttonLayout);

        description.add(header, info, addressLayout, grids, buttonAlign);
        card.add(/*image,*/ description);
        card.setHeight("100%");
        card.getStyle().set("background", "#FFFFFF");
        add(card);
	}
	
	@Override
	public void setParameter(BeforeEvent event, String parameter) {
		// TODO Auto-generated method stub
		
	}

}
