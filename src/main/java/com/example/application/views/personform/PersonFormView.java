package com.example.application.views.personform;

import com.example.application.data.entity.SamplePerson;
import com.example.application.data.service.SamplePersonService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.router.PageTitle;
import com.example.application.views.MainLayout;
import com.example.application.views.cardlist.CardListView;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.notification.NotificationVariant;

@Route(value = "new-offer", layout = MainLayout.class)
@PageTitle("Agregar Nueva Oferta")
public class PersonFormView extends Div {

    private TextField postName = new TextField("Nombre del Trabajo");
    private TextArea description = new TextArea("Descripción");
    private DatePicker dateFrom = new DatePicker("Fecha de Inicio");
    private DatePicker dateTo = new DatePicker("Fecha de Fin");
    private BigDecimalField salary = new BigDecimalField("Salario");
    private IntegerField vacancies = new IntegerField("Número de Vacantes");
    private IntegerField minAge = new IntegerField("Edad mínima");
    private IntegerField maxAge = new IntegerField("Edad máxima");
    private RadioButtonGroup<String> gender = new RadioButtonGroup<>();
    private ComboBox<String> status = new ComboBox<>();
    private ComboBox<String> employer = new ComboBox<>();
    private ComboBox<String> location = new ComboBox<>();    
    private EmailField email = new EmailField("Email address");

    private Button cancel = new Button("Cancelar");
    private Button save = new Button("Agregar");

    private Binder<SamplePerson> binder = new Binder(SamplePerson.class);

    public PersonFormView(SamplePersonService personService) {
        addClassName("person-form-view");

        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        binder.bindInstanceFields(this);
        clearForm();

        cancel.addClickListener(e -> clearForm());
        save.addClickListener(e -> saveOffer() /*{
            personService.update(binder.getBean());
            Notification.show(binder.getBean().getClass().getSimpleName() + " details stored.");
            clearForm();
        }*/);
    }

    private void clearForm() {
        binder.setBean(new SamplePerson());
    }
    
    private void saveOffer() {
    	Notification notification = new Notification("Oferta Agregada", 3000);
    	notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
    	notification.open();
    }

    private Component createTitle() {
        return new H3("Datos de la Oferta");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        email.setErrorMessage("Please enter a valid email address");
        gender.setLabel("Género");
        gender.setItems("Femenino", "Masculino", "Ambos");
        status.setLabel("Estatus");
        status.setItems("Público", "Oculto");
        status.setPlaceholder("Seleccione...");
        employer.setLabel("Empleador");
        employer.setItems("Banco Mercantil", "Empresas Polar", "Citrus Software Solutions", "Diageo", "Constructora Sambil", "EY Consultores", "Nestlé", "Calzados Apolo");
        employer.setPlaceholder("Seleccione...");
        location.setLabel("Ubicación");
        location.setItems("Barquisimeto", "Caracas", "Maracaibo", "Maracay", "Pto. Ordaz", "Valencia");
        location.setPlaceholder("Seleccione...");
        description.setPlaceholder("Descripción del trabajo...");
        minAge.setHasControls(true);
        minAge.setMin(10);
        minAge.setMax(80);
        maxAge.setHasControls(true);
        maxAge.setMin(10);
        maxAge.setMax(110);
        vacancies.setHasControls(true);
        vacancies.setMin(1);
        formLayout.add(postName, description, employer, status, dateFrom, dateTo, gender, salary, minAge, maxAge, vacancies, location); 
        return formLayout;
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save);
        buttonLayout.add(cancel);
        return buttonLayout;
    }

}
