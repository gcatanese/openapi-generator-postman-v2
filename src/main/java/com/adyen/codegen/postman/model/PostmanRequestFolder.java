package com.adyen.codegen.postman.model;

import java.util.Objects;

public class PostmanRequestFolder {

	private final String name;
	private final String description;

	public PostmanRequestFolder(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
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
