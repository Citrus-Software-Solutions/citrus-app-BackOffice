package com.citrus.backoffice.shared.ports;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public interface APIPort {

	public List<JsonNode> requestGetList(String parameter);
	public JsonNode requestGet(String parameter);
	
}
