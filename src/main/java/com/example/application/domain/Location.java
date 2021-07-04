package com.example.application.domain;

import com.example.application.domain.valueobjects.LocationId;
import com.example.application.domain.valueobjects.LocationName;
import com.example.application.domain.valueobjects.LocationType;

public class Location {
	private LocationId id;
	private LocationName name;
	private LocationType type;
	private Location parent;
	
	public Location(LocationId id, LocationName name, LocationType type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}
	
	public Location(LocationId id, LocationName name, LocationType type, Location parent) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.parent = parent;
	}
	
	public LocationId getId() {
		return this.id;
	}
	
	public void setId(LocationId id) {
		this.id = id;
	}
	
	public LocationName getName() {
		return this.name;
	}
	
	public void setName(LocationName name) {
		this.name = name;
	}
	
	public LocationType getType() {
		return this.type;
	}
	
	public void setType(LocationType type) {
		this.type = type;
	}
	
	public Location getParent() {
		return this.parent;
	}
	
	public void setParent(Location parent) {
		this.parent = parent;
	}
}
