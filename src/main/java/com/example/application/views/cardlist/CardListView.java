package com.example.application.views.cardlist;

import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.example.application.views.MainLayout;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "card-list", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@PageTitle("Ofertas de Trabajo")
public class CardListView extends Div implements AfterNavigationObserver {

    Grid<Person> grid = new Grid<>();

    public CardListView() {
        addClassName("card-list-view");
        setSizeFull();
        grid.setHeight("100%");
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS);
        grid.addComponentColumn(person -> createCard(person));
        add(grid);
    }

    private HorizontalLayout createCard(Person person) {
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

        Span name = new Span(person.getName());
        name.addClassName("name");
        Span date = new Span(person.getDate());
        date.addClassName("date");
        header.add(name, date);

        Span post = new Span(person.getPost());
        post.addClassName("post");

        HorizontalLayout actions = new HorizontalLayout();
        actions.addClassName("actions");
        actions.setSpacing(false);
        actions.getThemeList().add("spacing-s");
        /*
        Icon likeIcon = VaadinIcon.MAP_MARKER.create();
        likeIcon.addClassName("icon"); 
        Span likes = new Span(person.getLikes());
        likes.addClassName("likes"); */
        Icon commentIcon = VaadinIcon.USERS.create();
        commentIcon.addClassName("icon");
        Span comments = new Span(person.getComments());
        comments.addClassName("comments");
        Icon shareIcon = VaadinIcon.CALENDAR.create();
        shareIcon.addClassName("icon");
        Span shares = new Span(person.getShares());
        shares.addClassName("shares");

        actions.add(commentIcon, comments, shareIcon, shares); //likeIcon, likes, 

        description.add(header, post, actions);
        card.add(/*image,*/ description);
        return card;
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {

        // Set some data when this view is displayed.
        List<Person> persons = Arrays.asList( //
                createPerson( "Analista de Finanzas - Banco Mercantil", "Público",
                        "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking).",
                        "Caracas", "2", "May 8 - May 15"),
                createPerson("Operador Industrial - Empresas Polar", "Público",
                        "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking).",
                        "Maracaibo", "4", "May 3 - Jun 2"),
                createPerson("Desarrollador Front-End - Citrus Software Solutions", "Oculto",
                        "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking).",
                        "Valencia", "1", "May 3 - May 24"),
                createPerson("Gerente Regional de Control de Suministros - Diageo", "Público",
                        "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking).",
                        "Valencia", "8", "Apr 22 - May 15"),
                createPerson("Ingeniero de Infraestructuras - Constructora Sambil", "Oculto",
                        "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking).",
                        "Caracas", "6", "Apr 21 - May 1"),
                createPerson("Operario de Limpieza - Frito Lay", "Oculto",
                        "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking).",
                        "Barquisimeto", "10", "Apr 17 - Apr 24"),
                createPerson("Cosultor de Mercadeo Senior - EY Consultores", "Público",
                        "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking).",
                        "Maracaibo", "3", "Apr 17 - Apr 20"),
                createPerson("Técnico de Computación - Bolsa de Valores de Caracas", "Oculto",
                        "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking).",
                        "Caracas", "2", "Mar 8 - Mar 22"),
                createPerson("Guardia de Seguridad - Centro Polo", "Público",
                        "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking).",
                        "Maracaibo", "5", "Mar 5 - Mar 12"),
                createPerson("Maestro Chocolatero - Nestlé", "Público",
                        "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking).",
                        "Maracay", "1", "Mar 5 - Mar 19"),
                createPerson("Cajero Central - Calzados Apolo", "Oculto",
                        "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking).",
                        "Caracas", "1", "Mar 4 - Mar 10"),
                createPerson("Bartender - Megalicor", "Público",
                        "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking).",
                        "Barquisimeto", "1", "Mar 2 - Mar 9")

        );

        grid.setItems(persons);
    }

    private static Person createPerson(/*String image,*/ String name, String date, String post, String likes,
            String comments, String shares) {
        Person p = new Person();
        //p.setImage(image);
        p.setName(name);
        p.setDate(date);
        p.setPost(post);
        p.setLikes(likes);
        p.setComments(comments);
        p.setShares(shares);

        return p;
    }

}
