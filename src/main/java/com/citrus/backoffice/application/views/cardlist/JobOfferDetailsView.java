package com.citrus.backoffice.application.views.cardlist;

import com.citrus.backoffice.application.views.MainLayout;
import com.citrus.backoffice.joboffer.app.JobOfferMapperMock;
import com.citrus.backoffice.joboffer.app.JobOfferMapperNest;
import com.citrus.backoffice.joboffer.domain.JobOffer;
import com.citrus.backoffice.shared.ports.MockPort;
import com.citrus.backoffice.shared.ports.NestPort;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
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

@Route(value = "joboffer", layout = MainLayout.class)
@PageTitle("Detalles de Oferta de Trabajo")
public class JobOfferDetailsView extends Div implements HasUrlParameter<String>{

	public JobOfferDetailsView() {
		addClassName("joboffer-details-view");
		setSizeFull();
	}
	
	private Dialog publishOffer() {
		Dialog publishDialog = new Dialog();
		
		publishDialog.add(new Text("Esta seguro que desea publicar esta oferta?"));
        Notification notification = new Notification();
        notification.setDuration(3000);
        Button confirmButton = new Button("Aceptar", event -> {
        	notification.setText("Oferta de trabajo publicada.");
        	notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            notification.open();
            publishDialog.close();
            UI.getCurrent().navigate(CardListView.class);
        });
        confirmButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        Button cancelButton = new Button("Cancelar", event -> {
        	publishDialog.close();
        });

        HorizontalLayout actions = new HorizontalLayout();
        actions.getThemeList().add("spacing-s");
        actions.add(confirmButton, cancelButton);
        publishDialog.add(actions);
		
		return publishDialog;
	}
	
	@Override
	public void setParameter(BeforeEvent event, String parameter) {
		var offer = new JobOfferMapperNest().getJobOffer(new NestPort(), Long.parseLong(parameter));
		
		if (offer != null)
			add(renderJobOffer(offer));
		else
			add(noItems());
	}

	private HorizontalLayout renderJobOffer(JobOffer offer) {
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
        
        String fullTitle = offer.getTitle().getValue() + " en " + offer.getEmployer().getEmployerName().getValue();
        Span name = new Span(fullTitle);
        name.addClassName("name");
        Span status = new Span("Estado: " + offer.getStatus().getValue());
        status.addClassName("status");
        
        header.add(name, status);
        
        VerticalLayout description = new VerticalLayout();
        description.addClassName("description");
        description.setSpacing(false);
        description.getThemeList().add("spacing-s");
        
        Span rate = new Span("Salario (Por hora): " + offer.getHourlyRate().getValue());
        rate.addClassName("information");
        Span duration = new Span("Duración: " + offer.getDuration().getValue() + " horas");
        duration.addClassName("information");
        Span location = null;
        if (offer.getAddress().getStreet2().getValue() != "null" || offer.getAddress().getStreet2().getValue() != " ") {
        	location = new Span("Locación: "
        		+ offer.getAddress().getStreet1().getValue() + ", "
        		+ offer.getAddress().getStreet2().getValue() + ", "
        		+ offer.getAddress().getCity().getValue() + ", "
        		+ offer.getAddress().getState().getValue() + ", "
        		+ offer.getAddress().getZip().getValue());
        } else {
        	location = new Span("Locación: "
            		+ offer.getAddress().getStreet1().getValue() + ", "
            		+ offer.getAddress().getCity().getValue() + ", "
            		+ offer.getAddress().getState().getValue() + ", "
            		+ offer.getAddress().getZip().getValue());
        }
        
        location.addClassName("information");
        
        HorizontalLayout actions = new HorizontalLayout();
        actions.addClassName("actions");
        actions.setSpacing(false);
        actions.getThemeList().add("spacing-s");
        Button publish = new Button("Publicar", e -> publishOffer().open());
        publish.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        actions.add(publish);
        
        description.add(actions, rate, duration, location);
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
