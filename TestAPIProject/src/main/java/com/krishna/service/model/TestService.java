package com.krishna.service.model;

public class TestService {
	private String description;

	private String name;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "[description = " + description + ", name = " + name + "]";
	}
}
