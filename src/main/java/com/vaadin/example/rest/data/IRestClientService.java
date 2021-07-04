package com.vaadin.example.rest.data;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public interface IRestClientService {

	public List<JsonNode> getAllPosts();
		
	
	
}
