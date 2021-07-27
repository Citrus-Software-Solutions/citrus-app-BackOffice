package com.citrus.backoffice.application.views.applicant;

import com.citrus.backoffice.application.views.MainLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "applicant", layout = MainLayout.class)
@PageTitle("Detalles de Aplicante")
public class ApplicantDetailsView extends Div implements HasUrlParameter<String>{

	@Override
	public void setParameter(BeforeEvent event, String parameter) {
		// TODO Auto-generated method stub
		
	}

}
