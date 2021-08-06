package com.citrus.backoffice.application.views.userlist;

import java.util.List;

import com.citrus.backoffice.application.views.MainLayout;
import com.citrus.backoffice.application.views.interviewlist.InterviewDetailsView;
import com.citrus.backoffice.shared.domain.User;
import com.citrus.backoffice.shared.ports.NestPort;
import com.citrus.backoffice.user.app.UserMapperNest;
import com.citrus.backoffice.user.app.UserServiceMock;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
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

        String fullTitle = user.getName().getValue();
        Span name = new Span(fullTitle);
        name.addClassName("name");
               
        Button details = new Button("Ver detalles", e -> UI.getCurrent().navigate(UserDetailsView.class, String.valueOf(user.getId().getValue())));
        details.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        details.addClassName("button");
        
        header.add(name, details);

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
    	List<User> users = new UserMapperNest().getUsers(new NestPort());
    	grid2.setItems(users);
    	
    	if (users.isEmpty()) {
    		add(noItems());
    	}
	}
}
