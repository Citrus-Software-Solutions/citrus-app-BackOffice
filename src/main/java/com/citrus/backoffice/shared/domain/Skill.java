package com.citrus.backoffice.shared.domain;

import com.citrus.backoffice.shared.domain.valueobjects.SkillCategory;
import com.citrus.backoffice.shared.domain.valueobjects.SkillId;
import com.citrus.backoffice.shared.domain.valueobjects.SkillName;

public class Skill {
	
	private SkillId id;
	private SkillName name;
	private SkillCategory category;
	
	public Skill() {
		
	}
	
	public Skill(SkillId id, SkillName name, SkillCategory category) {
		this.id = id;
		this.name = name;
		this.category = category;
	}
	
	public SkillId getId() {
		return id;
	}
	
	public void setId(SkillId id) {
		this.id = id;
	}
	
	public SkillName getName() {
		return name;
	}
	
	public void setName(SkillName name) {
		this.name = name;
	}

	public SkillCategory getCategory() {
		return category;
	}

	public void setCategory(SkillCategory category) {
		this.category = category;
	}
	
}
