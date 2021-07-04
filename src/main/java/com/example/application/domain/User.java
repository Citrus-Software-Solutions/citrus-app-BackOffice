package com.example.application.domain;

import com.example.application.domain.valueobjects.Document;
import com.example.application.domain.valueobjects.Email;
import com.example.application.domain.valueobjects.UserId;
import com.example.application.domain.valueobjects.UserName;

public class User {
	private UserId id;
	private Document document;
	private UserName name;
	private Email email;
	private Location location;
	
	public UserId getId() {
		return id;
	}
	
	public void setId(UserId id) {
		this.id = id;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public UserName getName() {
		return name;
	}

	public void setName(UserName name) {
		this.name = name;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
