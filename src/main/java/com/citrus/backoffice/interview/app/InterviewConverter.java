package com.citrus.backoffice.interview.app;

import java.util.List;

import com.citrus.backoffice.interview.domain.Interview;
import com.fasterxml.jackson.databind.JsonNode;

public interface InterviewConverter {

	public Interview toInterview(JsonNode node);
	public JsonNode toJsonNode(Interview interview);
	public List<Interview> toInterviewList(List<JsonNode> nodes);
	public List<JsonNode> toJsonNodeList(List<Interview> interviews);
	
}
