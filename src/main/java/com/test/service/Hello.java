package com.test.service;

import java.io.Serializable;

public class Hello implements Serializable{

	private static final long serialVersionUID = -1503632480270332292L;

	private Long id;
	private String name;
	private String description;
	
	public Hello() {}

	public Hello(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

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

	@Override
	public String toString() {
		return "Hello [name=" + name + ", description=" + description + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
