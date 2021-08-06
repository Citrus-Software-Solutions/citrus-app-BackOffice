package com.citrus.backoffice.application.views.EmployersJobOffersList;

import java.util.List;

import com.citrus.backoffice.application.application_layer.ListEmployersOffers;
import com.citrus.backoffice.application.views.MainLayout;
import com.citrus.backoffice.joboffer.domain.JobOffer;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "employers-offers", layout = MainLayout.class)
@PageTitle("Ofertas de Trabajo")
public class EmployersJobOffersListView extends Div implements AfterNavigationObserver {

    Grid<JobOffer> grid2 = new Grid<>();
	
	public EmployersJobOffersListView() {
	    // Content goes here.
        addClassName("card-list-view");
        setSizeFull();
        grid2.setHeight("100%");
        grid2.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS);
        grid2.addComponentColumn(offer -> createCard(offer));
        add(grid2);
	  }

    private HorizontalLayout createCard(JobOffer offer) {
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

        String fullTitle = offer.getTitle().getValue(); // + "   -   " + offer.getEmployer().getEmployerName().getValue();
        Span name = new Span(fullTitle);
        name.addClassName("name");
        
        //String status = "(" + offer.getStatus().getValue() + ")";
        //Span date = new Span(status);
        //date.addClassName("date");  
        Span post = new Span(offer.getEmployer().getEmployerName().getValue());
        post.addClassName("post");
        header.add(name,post/*, date*/);

        

        HorizontalLayout actions = new HorizontalLayout();
        actions.addClassName("actions");
        actions.setSpacing(false);
        actions.getThemeList().add("spacing-s");
        
        Icon shareIcon = VaadinIcon.MAP_MARKER.create();
        shareIcon.addClassName("icon");
        String dateRange = "Hasta el  " + offer.getDeadline().getValue(); // + "   al   " + offer.getFinishingDate().getValue(); 
        Span shares = new Span(dateRange);
        shares.addClassName("dates");

        actions.add(shareIcon, shares); 

        description.add(header,/* post,*/ actions);
        card.add(description);
        return card;
    }
	
	
	@Override
    public void afterNavigation(AfterNavigationEvent event) {
    	List<JobOffer> offers = ListEmployersOffers.listAllEmployersOffers();
    	grid2.setItems(offers);

    }

}
