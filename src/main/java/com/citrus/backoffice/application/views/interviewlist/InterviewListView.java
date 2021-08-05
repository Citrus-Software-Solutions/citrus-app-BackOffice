package com.citrus.backoffice.application.views.interviewlist;

import java.util.List;

import com.citrus.backoffice.application.views.MainLayout;
import com.citrus.backoffice.interview.app.InterviewMapperMock;
import com.citrus.backoffice.interview.domain.Interview;
import com.citrus.backoffice.shared.ports.MockPort;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "interviews", layout = MainLayout.class)
@PageTitle("Entrevistas de trabajo")
public class InterviewListView extends Div implements AfterNavigationObserver {

	Grid<Interview> grid2 = new Grid<>();
	
	public InterviewListView() {
		addClassName("interview-list-view");
		setSizeFull();
        grid2.setHeight("100%");
        grid2.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS);
        grid2.addComponentColumn(interview -> createCard(interview));
        add(grid2);
	}
	
	private HorizontalLayout createCard(Interview interview) {
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

        String fullTitle = "Entrevista de " + interview.getEmployee().getFullName().getValue();
        Span name = new Span(fullTitle);
        name.addClassName("name");
        Span status = new Span("(" + interview.getStatus().getValue() + ")");
        status.addClassName("status");
        Button details = new Button("Ver detalles", e -> UI.getCurrent().navigate(InterviewDetailsView.class, String.valueOf(interview.getId().getValue())));
        details.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        details.addClassName("button");
        
        header.add(name, status, details);

        description.add(header);
        card.add(description);
        
        return card;
    }
	
	private HorizontalLayout noItems() {
		HorizontalLayout card = new HorizontalLayout();
        card.addClassName("card");
        card.setSpacing(false);
        card.getThemeList().add("spacing-s");

        HorizontalLayout header = new HorizontalLayout();
        header.addClassName("header");
        header.setSpacing(false);
        header.getThemeList().add("spacing-s");
        
        String fullTitle = "No se encontraron elementos.";
        Span name = new Span(fullTitle);
        name.addClassName("name");
               
        header.add(name);
        card.add(header);
        
        return card;
	}
	
	@Override
	public void afterNavigation(AfterNavigationEvent event) {
    	List<Interview> interviews = new InterviewMapperMock().getInterviews(new MockPort());
    	grid2.setItems(interviews);
    	
    	if (interviews.isEmpty()) {
    		add(noItems());
    	}
	}
}
