package com.cooksys.day_8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	String url = "jdbc:postgresql://localhost:5432";
//    	
//    	String query = "select name from employee";
//    	
//        try {
//			Class.forName("org.postgresql.Driver");
//		} catch (ClassNotFoundException e) {
//			System.out.println("Unable to load Postgresql Driver:");
//			e.printStackTrace();
//		}
//        
//       try (Connection connection = DriverManager.getConnection(url, "postgres", "bondstone");) {
//    	   Statement stmt = connection.createStatement();
//    	   ResultSet rs = stmt.executeQuery(query);
//    	   while (rs.next()) {
//    		   System.out.println(rs.getString("name"));
//    	   }
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	EmployeeDAO emDAO = new EmployeeDAO("jdbc:postgresql://localhost:5432/", "postgres", "bondstone");
    	List<Employee> employees = emDAO.get();
    	for (Employee em : employees) {
    		System.out.println(em.getName() + " makes $" + em.getSalary());
    	}
    	Employee will = emDAO.getByName("Will");
    	if (will != null) {
    		System.out.println(will.getName() + " makes $" + will.getSalary());
    	}
    }
}
