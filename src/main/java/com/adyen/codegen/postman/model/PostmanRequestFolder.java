package com.adyen.codegen.postman.model;

import java.util.Objects;

public class PostmanRequestFolder {

	String name;
	String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PostmanRequestFolder name(String name) {
		this.name = name;
		return this;
	}

	public PostmanRequestFolder description(String description) {
		this.description = description;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		PostmanRequestFolder folder = (PostmanRequestFolder) o;
		return Objects.equals(name, folder.name) && Objects.equals(description, folder.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, description);
	}
}
