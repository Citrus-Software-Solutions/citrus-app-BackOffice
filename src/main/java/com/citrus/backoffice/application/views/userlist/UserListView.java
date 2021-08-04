package com.citrus.backoffice.application.views.userlist;

import java.awt.Button;
import java.util.List;

import com.citrus.backoffice.application.views.MainLayout;
import com.citrus.backoffice.interview.app.InterviewServiceMock;
import com.citrus.backoffice.interview.domain.Interview;
import com.citrus.backoffice.shared.domain.User;
import com.citrus.backoffice.user.app.UserServiceMock;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Anchor;
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

@Route(value = "users", layout = MainLayout.class)
@PageTitle("Usuarios")
public class UserListView extends Div implements AfterNavigationObserver {

	Grid<User> grid2 = new Grid<>();
	
	public UserListView() {
		addClassName("user-list-view");
		setSizeFull();
        grid2.setHeight("100%");
        grid2.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS);
        grid2.addComponentColumn(user -> createCard(user));
        add(grid2);
	}
	
	private HorizontalLayout createCard(User user) {
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

        String fullTitle = "Usuario de ID" + user.getId().getValue();
        Span name = new Span(fullTitle);
        name.addClassName("name");
               
        header.add(name);

        HorizontalLayout info = new HorizontalLayout();
        Span duration = new Span(user.getDocument().getValue() + "documentos");
        duration.addClassName("document");
        Span status = new Span("(" + user.getEmail().getValue() + ")");
        status.addClassName("email");
        info.add(duration, status);

        HorizontalLayout actions = new HorizontalLayout();
        actions.addClassName("actions");
        actions.setSpacing(false);
        actions.getThemeList().add("spacing-s");

       /* Anchor accessInterview = new Anchor(user.getAccessURL().getValue(), "Ver detalles de usuario");
        accessInterview.setTarget("_blank");
        accessInterview.setClassName("accessbutton");
        Icon dateIcon = VaadinIcon.CALENDAR.create();
        dateIcon.addClassName("icon");
        Span date = new Span(user.getStartDate().getValue());
        date.addClassName("date");

        actions.add(dateIcon, date, accessInterview);*/

        description.add(header, info, actions);
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
		var service = new UserServiceMock();
		//var service = new InterviewServiceSpring();
    	List<User> users = service.getUsers();
    	grid2.setItems(users);
    	
    	if (users.isEmpty()) {
    		add(noItems());
    	}
	}
}