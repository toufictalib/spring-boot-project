package com.test.springbootproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.springbootproject.model.User;

public class UserRequest {

	private int id;

	@JsonProperty(value="name_user")
	private String name;

	private int age;

	public UserRequest() {

	}

	public UserRequest(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public User toUser() {
		return new User(name, age);
	}

	public static UserRequest fromUser(User user) {
		return new UserRequest(user.getId(), user.getName(), user.getAge());
	}
}
