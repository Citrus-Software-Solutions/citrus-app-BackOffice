package com.citrus.backoffice.application.views.applicantlist;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.citrus.backoffice.application.views.MainLayout;
import com.citrus.backoffice.employee.domain.Employee;
import com.citrus.backoffice.employee.domain.valueobjects.EmployeeName;
import com.citrus.backoffice.jobapplication.domain.JobApplication;
import com.citrus.backoffice.jobapplication.domain.valueobjects.ApplicationDate;
import com.citrus.backoffice.jobapplication.domain.valueobjects.ApplicationId;
import com.citrus.backoffice.jobapplication.domain.valueobjects.ApplicationStatus;
import com.citrus.backoffice.joboffer.domain.JobOffer;
import com.citrus.backoffice.joboffer.domain.valueobjects.Title;
import com.citrus.backoffice.shared.domain.valueobjects.UserId;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "applicants", layout = MainLayout.class)
@PageTitle("Aplicantes")
public class ApplicantListView extends Div implements AfterNavigationObserver {

	Grid<JobApplication> grid2 = new Grid<>();
	
	public ApplicantListView() {
        addClassName("applicant-list-view");
        setSizeFull();
        grid2.setHeight("100%");
        grid2.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS);
        grid2.addComponentColumn(application -> createCard(application));
        add(grid2);
    }
	
	private HorizontalLayout createCard(JobApplication application) {
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

        String fullTitle = application.getEmployee().getFullName().getValue() + " aplicó para " + application.getJobOffer().getTitle().getValue();
        Span name = new Span(fullTitle);
        name.addClassName("name");

        Button details = new Button("Ver Detalles");
        
        header.add(name, details);
        description.add(header);
        card.add(description);
        return card;
    }
	
	@Override
	public void afterNavigation(AfterNavigationEvent event) {
		List<JobApplication> applications = new ArrayList<>();
		applications.add(JobApplication.createApplication(
				new ApplicationId(0),
				new ApplicationDate(new Date(0)),
				new Employee(new UserId(0)),
				new JobOffer(),
				new ApplicationStatus(2)));
		applications.get(0).getEmployee().setFullName(new EmployeeName("Nombre Apellido"));
		applications.get(0).getJobOffer().setTitle(new Title("Trabajo"));
		grid2.setItems(applications);
	}
	
}
