package com.example.application.views.cardlist;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.application.views.cardlist.MainLayout2;
import com.fasterxml.jackson.databind.JsonNode;
import com.vaadin.example.rest.data.RestClientService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("In-Memory JSON | Vaadin REST Examples")
@Route(value = "in-memory-json", layout = MainLayout2.class)
public class InMemoryJSONView extends Main {

	public InMemoryJSONView(@Autowired RestClientService service) {
		// The second example does not use a DTO, but raw JSON instead using the Jackson
		// library included with Spring. The data is a List of JSON nodes; for each
		// column, we define how to get the correct data from the node.

		// This is useful when the REST API returns dynamic data
		final Grid<JsonNode> postsGrid = new Grid<JsonNode>();

		postsGrid.addColumn(node -> node.get("id")).setHeader("Id").setTextAlign(ColumnTextAlign.END);
		postsGrid.addColumn(node -> node.get("name")).setHeader("Name");
		postsGrid.addColumn(node -> node.get("description")).setHeader("Description");
		postsGrid.addColumn(node -> node.get("salary")).setHeader("salary");
		postsGrid.addColumn(node -> node.get("status")).setHeader("status");
		postsGrid.addColumn(node -> node.get("available_Vacans")).setHeader("Vacantes disponibles");
		postsGrid.addColumn(node -> node.get("min_Age")).setHeader("Edad mínima");
		postsGrid.addColumn(node -> node.get("max_Age")).setHeader("Edad máxima");
		postsGrid.addColumn(node -> node.get("gender")).setHeader("Género");
		postsGrid.addColumn(node -> node.get("date_Begin")).setHeader("Fecha Inicio");
		postsGrid.addColumn(node -> node.get("date_End")).setHeader("Fecha Fin");
		// Fetch all data and show
		final Button fetchPosts = new Button("Fetch all posts", e -> postsGrid.setItems(service.getAllPosts()));

		fetchPosts.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		add(fetchPosts, postsGrid);

	}
}
