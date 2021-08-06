package com.citrus.backoffice.shared.domain;

import com.citrus.backoffice.shared.domain.valueobjects.City;
import com.citrus.backoffice.shared.domain.valueobjects.State;
import com.citrus.backoffice.shared.domain.valueobjects.Street1;
import com.citrus.backoffice.shared.domain.valueobjects.Street2;
import com.citrus.backoffice.shared.domain.valueobjects.Zip;

public class Address {

	private Street1 street1;
	private Street2 street2;
	private City city;
	private State state;
	private Zip zip;
	
	public Address(Street1 street1, Street2 street2, City city, State state, Zip zip) {
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public Street1 getStreet1() {
		return street1;
	}
	
	public void setStreet1(Street1 street1) {
		this.street1 = street1;
	}

	public Street2 getStreet2() {
		return street2;
	}

	public void setStreet2(Street2 street2) {
		this.street2 = street2;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Zip getZip() {
		return zip;
	}

	public void setZip(Zip zip) {
		this.zip = zip;
	}
	
}
