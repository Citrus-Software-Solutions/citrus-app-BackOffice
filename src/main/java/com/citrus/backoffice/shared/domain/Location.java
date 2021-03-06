package com.citrus.backoffice.shared.domain;

import com.citrus.backoffice.shared.domain.valueobjects.LocationId;
import com.citrus.backoffice.shared.domain.valueobjects.LocationName;
import com.citrus.backoffice.shared.domain.valueobjects.LocationType;

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
	
	public Location(long asLong, long asLong2, long asLong3) {
		// TODO Auto-generated constructor stub
		
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
