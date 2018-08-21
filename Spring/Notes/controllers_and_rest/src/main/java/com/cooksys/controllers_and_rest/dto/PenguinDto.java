package com.cooksys.controllers_and_rest.dto;

import java.util.List;

import com.cooksys.controllers_and_rest.entity.Penguin;

public class PenguinDto {
	
	private int id;
	private String name;
	private int age;
	private List<Penguin> friends;
	
	public PenguinDto () {}
	
	public PenguinDto (int id, String name, int age, List<Penguin> friends) {
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
