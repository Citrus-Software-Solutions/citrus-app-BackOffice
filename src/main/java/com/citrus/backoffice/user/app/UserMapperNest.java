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
import com.citrus.backoffice.shared.domain.valueobjects.UserStatus;
import com.citrus.backoffice.shared.domain.valueobjects.Username;
import com.citrus.backoffice.shared.ports.APIPort;
import com.fasterxml.jackson.databind.JsonNode;

@SuppressWarnings("serial")
@Service
public class UserMapperNest implements Serializable, UserMapper{

	@Override
	public List<User> getUsers(APIPort port) {
		List<User> users = new ArrayList<>();
		
		try {
			for (JsonNode n: port.requestGetList("users")) {
				users.add(new User(
						new UserId(n.get("id").asLong()),
						new Username(n.get("username").asText()),
						new Email(n.get("email").asText()),
						new UserStatus(n.get("status").asText())
						));
			}		
		} catch(Exception e) {
			//Couldn't connect to the API
		}
		return users;
	}

	@Override
	public User getUser(APIPort port, long id) {
		var user = new User();
		var node = port.requestGet("users/" + String.valueOf(id));
		
		user.setId(new UserId(node.get("id").asLong()));
		user.setName(new Username(node.get("username").asText()));
		user.setEmail(new Email(node.get("email").asText()));
		user.setStatus(new UserStatus(node.get("status").asText()));
		
		return user;
	}

	
}
