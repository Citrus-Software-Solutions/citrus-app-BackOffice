package com.citrus.backoffice.shared.ports;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

public interface APIPort {

	public List<JsonNode> requestGetList(String parameter);
	public JsonNode requestGet(String parameter);
	public void requestPut(String parameter, Object o);
	
}
