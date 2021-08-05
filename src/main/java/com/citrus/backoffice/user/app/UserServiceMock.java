package com.citrus.backoffice.user.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

import com.citrus.backoffice.employee.domain.Employee;
import com.citrus.backoffice.interview.domain.Interview;
import com.citrus.backoffice.shared.domain.Location;
import com.citrus.backoffice.shared.domain.User;
import com.citrus.backoffice.interview.domain.valueobjects.InterviewAccessURL;
import com.citrus.backoffice.interview.domain.valueobjects.InterviewDuration;
import com.citrus.backoffice.interview.domain.valueobjects.InterviewId;
import com.citrus.backoffice.interview.domain.valueobjects.InterviewStatus;
import com.citrus.backoffice.shared.domain.valueobjects.DateFormat;
import com.citrus.backoffice.shared.domain.valueobjects.Document;
import com.citrus.backoffice.shared.domain.valueobjects.Email;
import com.citrus.backoffice.shared.domain.valueobjects.UserId;
import com.citrus.backoffice.shared.domain.valueobjects.Username;
import com.fasterxml.jackson.databind.JsonNode;

@SuppressWarnings("serial")
@Service
public class UserServiceMock implements Serializable, UserService{
	@Value("${PORT: 3000}")
	private String serverPort;
	
	@Override
	public List<User> getUsers() {
		final String url = String.format("https://60f246b86d44f300177885e0.mockapi.io/api/User");
		List<User> users = new ArrayList<>();
		
		try {
			//Fetch interviews from API
			final RequestHeadersSpec<?> spec = WebClient.create().get().uri(url);
			
			//Map results
			final List<JsonNode> nodes = spec.retrieve().toEntityList(JsonNode.class).block().getBody();
			
			for (JsonNode n: nodes) {
				users.add(new User(
						new UserId(n.get("id").asLong()),
						new Document(n.get("document").asLong()),
						new Username(n.get("username").asDouble()),
						new Email(n.get("email").asText())
						));
			}		
		} catch(Exception e) {
			//Couldn't connect to the API
		}
		return users;
	}

	
}
