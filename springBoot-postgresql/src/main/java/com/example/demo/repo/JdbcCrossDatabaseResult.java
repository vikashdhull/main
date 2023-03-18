package com.example.demo.repo;

import java.sql.*;

public class JdbcCrossDatabaseResult {

	 public static void main(String[] args) {
	        // Load the JDBC driver
	        try {
	            Class.forName("org.postgresql.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }

	        // Connect to the database
	        try (Connection conn = DriverManager.getConnection(
	                "jdbc:postgresql://localhost:5432/db1", "postgres", "Chetu@123")) {

	            // Prepare the query
	            String query = "SELECT * FROM table2 LEFT JOIN book ON table2.id = book.id WHERE table2.name = 'sunny';";
	    //    	String query = "SELECT * FROM book";

	            // Execute the query
	            try (Statement stmt = conn.createStatement();
	                 ResultSet rs = stmt.executeQuery(query)) {

	                // Fetch the results
	                while (rs.next()) {
	                    // Process the results
	                    // you can get data by column name or by index
	                    
	                    int id = rs.getInt("id");
	                    String author = rs.getString("author");
	                    String title = rs.getString("title");
	                    String name = rs.getString("name");
	                    System.out.println("id: " + id + " author: " + author+"  title : "+title+"     name : "+name);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
