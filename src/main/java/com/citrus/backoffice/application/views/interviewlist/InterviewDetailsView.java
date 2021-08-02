package com.citrus.backoffice.application.views.interviewlist;

import com.citrus.backoffice.application.views.MainLayout;
import com.citrus.backoffice.interview.app.InterviewServiceMock;
import com.citrus.backoffice.interview.domain.Interview;
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


@Route(value = "interview", layout = MainLayout.class)
@PageTitle("Detalles de Entrevista")
public class InterviewDetailsView extends Div implements HasUrlParameter<String>{

	public InterviewDetailsView() {
		addClassName("interview-details-view");
		setSizeFull();
	}
	
	@Override
	public void setParameter(BeforeEvent event, String parameter) {
		var service = new InterviewServiceMock();
		var interview = service.getInterview(Long.parseLong(parameter));
		//var service = new InterviewServiceSpring();
		
		if (interview != null)
			add(renderInterview(interview));
		else
			add(noItems());
	}
	
	private FormLayout createFormLayout() {
		FormLayout formLayout = new FormLayout();
		
		DatePicker date = new DatePicker("Nueva fecha para la reunion");
		
		return formLayout;
	}
	
	private Dialog rescheduleInterview() {
		Dialog rescheduleDialog = new Dialog();
        rescheduleDialog.add(new DatePicker("Nueva fecha para la reunion"));
        Notification notification = new Notification();
        notification.setDuration(3000);
        Button confirmButton = new Button("Aceptar", event -> {
        	notification.setText("Entrevista Reagendada");
        	notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            notification.open();
            rescheduleDialog.close();
            UI.getCurrent().getPage().reload();
        });
        Button cancelButton = new Button("Cancelar", event -> {
            rescheduleDialog.close();
        });
        
        HorizontalLayout actions = new HorizontalLayout();
        actions.getThemeList().add("spacing-s");
        actions.add(confirmButton, cancelButton);
        rescheduleDialog.add(actions);
        return rescheduleDialog;
	}
	
	private Dialog cancelInterview() {
		Dialog cancelDialog = new Dialog();
		cancelDialog.add(new Text("Esta seguro que desea cancelar esta entrevista?"));
        Notification notification = new Notification();
        notification.setDuration(3000);
        Button confirmButton = new Button("Aceptar", event -> {
        	notification.setText("Entrevista Cancelada");
        	notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            notification.open();
            cancelDialog.close();
            UI.getCurrent().navigate(InterviewListView.class);
        });
        Button cancelButton = new Button("Salir", event -> {
            cancelDialog.close();
        });

        HorizontalLayout actions = new HorizontalLayout();
        actions.getThemeList().add("spacing-s");
        actions.add(confirmButton, cancelButton);
        cancelDialog.add(actions);
        return cancelDialog;
	}
	
	private HorizontalLayout renderInterview(Interview interview) {
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
        
        String fullTitle = "Entrevista de " + interview.getEmployee().getFullName().getValue();
        Span name = new Span(fullTitle);
        name.addClassName("name");
        
        Button enter = new Button("Ingresar a la reunion");
        enter.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        Anchor anchor = new Anchor("https://www.google.com/", enter);
        anchor.setTarget("_blank");
        header.add(name, anchor);
        
        VerticalLayout description = new VerticalLayout();
        description.addClassName("description");
        description.setSpacing(false);
        description.getThemeList().add("spacing-s");
        
        Span duration = new Span("Duracion: " + interview.getDuration().getValue() + " minutos");
        duration.addClassName("information");
        Span status = new Span("Estado: " + interview.getStatus().getValue());
        status.addClassName("information");
        Span date = new Span("Fecha: " + interview.getStartDate().getValue());
        date.addClassName("information");

        HorizontalLayout actions = new HorizontalLayout();
        actions.addClassName("actions");
        actions.setSpacing(false);
        actions.getThemeList().add("spacing-s");
        Button reschedule = new Button("Reagendar", e -> rescheduleInterview().open());
        Button cancel = new Button("Cancelar", e -> cancelInterview().open());
        actions.add(reschedule, cancel);
        
        description.add(duration, status, date, actions);
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
