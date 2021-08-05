package com.citrus.backoffice.shared.domain;

import com.citrus.backoffice.shared.domain.valueobjects.Document;
import com.citrus.backoffice.shared.domain.valueobjects.Email;
import com.citrus.backoffice.shared.domain.valueobjects.UserId;
import com.citrus.backoffice.shared.domain.valueobjects.Username;

public class User {
	private UserId id;
	private Document document;
	private Username name;
	private Email email;
	private Location location;

	public User(UserId id, Document document, Username username, Email email) {
		this.id = id;
		this.document = document;
		this.name = username;
		this.email = email;
	}

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

	public Username getName() {
		return name;
	}

	public void setName(Username name) {
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
