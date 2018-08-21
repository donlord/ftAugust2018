package com.cooksys.day_8;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	
	private String url;
	private String user;
	private String password;
	
	public EmployeeDAO (String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to load the PostgreSQL driver:");
			e.printStackTrace();
		}
	}
	
	
	public List<Employee> get () {
		List<Employee> employees = new ArrayList<Employee>();
		try (Connection connection = DriverManager.getConnection(this.url, this.user, this.password)) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee");
			while (rs.next()) {
				employees.add(new Employee(rs.getInt("id"), rs.getString("name"), rs.getDouble("salary")));
			}
		} catch (SQLException e) {
			System.out.println("Something went wrong when trying to retrieve employees:");
			e.printStackTrace();
		}
		return employees;
	}
	
	/**
	 * Grabs an employee with the given name from the database.
	 * @param name - The name of the employee to pull from the database
	 * @return null if the employee is not found. Otherwise, the employee 
	 * with the given name from the database.
	 */
	public Employee getByName(String name) {
		Employee employee = null;
		try (Connection connection = DriverManager.getConnection(this.url, this.user, this.password)) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee where name='" + name + "'");
			while (rs.next()) {
				employee = new Employee(rs.getInt("id"), rs.getString("name"), rs.getDouble("salary"));
			}
		} catch (SQLException e) {
			System.out.println("Something went wrong when trying to retrieve the Employee " + name + ":");
			e.printStackTrace();
		}
		return employee;
	}
	
	

}
