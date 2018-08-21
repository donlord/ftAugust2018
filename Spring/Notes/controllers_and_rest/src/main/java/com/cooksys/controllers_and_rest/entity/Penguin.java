package com.cooksys.controllers_and_rest.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Penguin {
	
	private int id;
	private String name;
	private int age;
	
	@JsonIgnore
	private List<Penguin> friends;
	
	public Penguin () {}
	
	public Penguin (int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public Penguin (int id, String name, int age, List<Penguin> friends) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.friends = friends;
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

	public List<Penguin> getFriends() {
		return friends;
	}

	public void setFriends(List<Penguin> friends) {
		this.friends = friends;
	}

}
