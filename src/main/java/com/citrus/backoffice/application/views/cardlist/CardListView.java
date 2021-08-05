package com.citrus.backoffice.application.views.cardlist;

import java.util.List;

import com.citrus.backoffice.application.views.MainLayout;
import com.citrus.backoffice.joboffer.app.JobOfferMapperMock;
import com.citrus.backoffice.joboffer.domain.JobOffer;
import com.citrus.backoffice.shared.ports.MockPort;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
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

@Route(value = "card-list", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@PageTitle("Ofertas de Trabajo")
public class CardListView extends Div implements AfterNavigationObserver {

    Grid<JobOffer> grid2 = new Grid<>();

    public CardListView() {
        addClassName("card-list-view");
        setSizeFull();
        grid2.setHeight("100%");
        grid2.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS);
        grid2.addComponentColumn(offer -> createCard(offer));
        add(grid2);
    }

    Grid<Person> grid = new Grid<>();
    rest RestService = new rest();
    /*public CardListView() {
        addClassName("card-list-view");
        setSizeFull();
        grid.setHeight("100%");
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS);
        grid.addComponentColumn(person -> createCard(person));
        add(grid);
        
        add(new H1("prueba"));
        
    }*/

    private HorizontalLayout createCard(JobOffer offer) {
        HorizontalLayout card = new HorizontalLayout();
        card.addClassName("card");
        card.setSpacing(false);
        card.getThemeList().add("spacing-s");
        /*
        Image image = new Image();
        image.setSrc(person.getImage()); */
        VerticalLayout description = new VerticalLayout();
        description.addClassName("description");
        description.setSpacing(false);
        description.setPadding(false);

        HorizontalLayout header = new HorizontalLayout();
        header.addClassName("header");
        header.setSpacing(false);
        header.getThemeList().add("spacing-s");

        String fullTitle = offer.getTitle().getValue() + "   -   " + offer.getEmployer().getEmployerName().getValue();
        Span name = new Span(fullTitle);
        name.addClassName("name");
        
        String status = "(" + offer.getStatus().getValue() + ")";
        Span date = new Span(status);
        date.addClassName("date");        
        Button details = new Button("Ver detalles", e -> UI.getCurrent().navigate(JobOfferDetailsView.class, String.valueOf(offer.getId().getValue())));
        details.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        details.addClassName("button");
        header.add(name, date, details);

        

        HorizontalLayout actions = new HorizontalLayout();
        actions.addClassName("actions");
        actions.setSpacing(false);
        actions.getThemeList().add("spacing-s");
        
        /*
        Icon likeIcon = VaadinIcon.MAP_MARKER.create();
        likeIcon.addClassName("icon"); 
        Span likes = new Span(person.getLikes());
        likes.addClassName("likes");
        Icon commentIcon = VaadinIcon.USERS.create();
        commentIcon.addClassName("icon");
        Span comments = new Span(person.getComments());
        comments.addClassName("comments"); */
        
        Icon shareIcon = VaadinIcon.CALENDAR.create();
        shareIcon.addClassName("icon");
        String dateRange = "Hasta el " + offer.getDeadline().getValue(); 
        Span shares = new Span(dateRange);
        shares.addClassName("dates");

        actions.add(shareIcon, shares); //likeIcon, likes, commentIcon, comments, 

        description.add(header, actions);
        card.add(/*image,*/ description);
        return card;
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
    	List<JobOffer> offers = new JobOfferMapperMock().getJobOffers(new MockPort());
    	//List<JobOffer> offers = ListJobOffers.listAllOffers();
    	grid2.setItems(offers);

    }

    

}
