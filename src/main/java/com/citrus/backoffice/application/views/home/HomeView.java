package com.citrus.backoffice.application.views.home;

import com.citrus.backoffice.application.views.MainLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainLayout.class)
@PageTitle("Bienvenido")
public class HomeView extends Div  {
	
	private String welcomeMsg = "¡Bienvenido!";
	
	public HomeView() {
		addClassName("card-list-view");
        setSizeFull();
        
		HorizontalLayout card = new HorizontalLayout();
        card.addClassName("card");
        card.setSpacing(false);
        card.getThemeList().add("spacing-s");
		
		H1 welcome = new H1(welcomeMsg);
		welcome.getStyle().set("color", "orange");
        
        VerticalLayout msgAlign = new VerticalLayout();
        msgAlign.setWidth("90%");
        msgAlign.setAlignItems(Alignment.CENTER); 
        msgAlign.add(welcome);	
        
        card.add(msgAlign);
        card.setHeight("100%");
        card.getStyle().set("background", "#FFFFFF");
        add(card);
		
	}

}
