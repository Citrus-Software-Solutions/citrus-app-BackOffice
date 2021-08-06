package com.citrus.backoffice.application.views.userlist;

import com.citrus.backoffice.application.views.MainLayout;
import com.citrus.backoffice.interview.app.InterviewMapperMock;
import com.citrus.backoffice.interview.app.InterviewMapperSpring;
import com.citrus.backoffice.interview.domain.Interview;
import com.citrus.backoffice.shared.domain.User;
import com.citrus.backoffice.shared.ports.MockPort;
import com.citrus.backoffice.shared.ports.NestPort;
import com.citrus.backoffice.shared.ports.SpringPort;
import com.citrus.backoffice.user.app.UserMapperNest;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route(value = "user", layout = MainLayout.class)
@PageTitle("Detalles de Usuario")
public class UserDetailsView extends Div implements HasUrlParameter<String>{

	public UserDetailsView() {
		addClassName("interview-details-view");
		setSizeFull();
	}
	
	@Override
	public void setParameter(BeforeEvent event, String parameter) {
		var user = new UserMapperNest().getUser(new NestPort(), Long.parseLong(parameter));
		
		if (user != null)
			add(renderInterview(user));
		else
			add(noItems());
	}
	
	private FormLayout createFormLayout() {
		FormLayout formLayout = new FormLayout();
		
		DatePicker date = new DatePicker("Nueva fecha para la reunion");
		
		return formLayout;
	}
	
	private HorizontalLayout renderInterview(User user) {
		HorizontalLayout entry = new HorizontalLayout();
        entry.addClassName("entry");
        entry.setSpacing(false);
        entry.getThemeList().add("spacing-s");
        
        VerticalLayout todo = new VerticalLayout();
        todo.addClassName("todo");
        todo.setSpacing(false);
        
        HorizontalLayout header = new HorizontalLayout();
        header.addClassName("header");
        header.setSpacing(false);
        header.getThemeList().add("spacing-s");
        
        String fullTitle = user.getName().getValue();
        Span name = new Span(fullTitle);
        name.addClassName("name");
        header.add(name);
        
        VerticalLayout description = new VerticalLayout();
        description.addClassName("description");
        description.setSpacing(false);
        description.getThemeList().add("spacing-s");
        
        Span duration = new Span("Correo: " + user.getEmail().getValue());
        duration.addClassName("information");
        Span status = new Span("Estado: " + user.getStatus().getValue());
        status.addClassName("information");
        
        description.add(duration, status);
        todo.add(header, description);
        entry.add(todo);
        
        return entry;
	}
	
	private HorizontalLayout noItems() {
		HorizontalLayout entry = new HorizontalLayout();
        entry.addClassName("entry");
        entry.setSpacing(false);
        entry.getThemeList().add("spacing-s");

        HorizontalLayout header = new HorizontalLayout();
        header.addClassName("header");
        header.setSpacing(false);
        header.getThemeList().add("spacing-s");
        
        String fullTitle = "No se encontraron elementos.";
        Span name = new Span(fullTitle);
        name.addClassName("name");
               
        header.add(name);
        entry.add(header);
        
        return entry;
	}

}
