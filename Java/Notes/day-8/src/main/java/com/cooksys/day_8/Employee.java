package com.cooksys.day_8;

public class Employee {
	
	private int id;
	private String name;
	private double salary;
	
	public Employee () {}
	
	public Employee (String name, Double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public Employee (int id, String name, Double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
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
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}

}