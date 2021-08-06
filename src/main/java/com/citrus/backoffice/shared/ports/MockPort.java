package com.citrus.backoffice.shared.ports;

import java.util.List;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

import com.fasterxml.jackson.databind.JsonNode;

import reactor.core.publisher.Mono;

public class MockPort implements APIPort {

	private final String defaultUrl = "https://60f246b86d44f300177885e0.mockapi.io/api/";
	
	@Override
	public List<JsonNode> requestGetList(String parameter) {
		RequestHeadersSpec<?> spec;
		List<JsonNode> nodes;
		
		try {
			//Fetch content from API
			spec = WebClient
					.create()
					.get()
					.uri(defaultUrl + parameter);
			
			//Map results
			nodes = spec.retrieve().toEntityList(JsonNode.class).block().getBody();
		} catch (Exception e){
			nodes = null;
		}
		return nodes;
	}

	@Override
	public JsonNode requestGet(String parameter) {
		RequestHeadersSpec<?> spec;
		JsonNode node;
		
		try {
			//Fetch content from API
			spec = WebClient
					.create()
					.get()
					.uri(defaultUrl + parameter);
			
			//Map results
			node = spec.retrieve().toEntity(JsonNode.class).block().getBody();
		} catch (Exception e){
			node = null;
		}
		return node;
	}

	@Override
	public void requestPut(String parameter, Object o) {
		RequestHeadersSpec<?> spec;
		
		spec = WebClient
				.create()
				.patch()
				.uri(defaultUrl + parameter)
				.body(Mono.just(o), o.getClass());
	}

}
