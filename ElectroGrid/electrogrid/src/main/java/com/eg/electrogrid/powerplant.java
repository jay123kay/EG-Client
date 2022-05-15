package com.eg.electrogrid;

import java.sql.*;

public class powerplant {

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/electrogrid", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String readPowerPlants() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border='1'><tr><th>ID</th> <th>Name</th><th>Type</th>"
					+ "<th>Address</th><th>Capacity</th>  <th>Update</th><th>Remove</th></tr>";
			
			String query = "select * from powerplants";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			// iterate through the rows in the result set
			while (rs.next()) {
				String id = Integer.toString(rs.getInt("id"));
				String name = rs.getString("name");
				String type = rs.getString("type");
				String address = rs.getString("address");
				String capacity = rs.getString("capacity");
				
				// Add into the html table
				output += "<tr><td><input id='hidPlantIDUpdate' name='hidPlantIDUpdate' type='hidden' value='" + id
						+ "'>" + name + "</td>";
				output += "<td>" + type + "</td>";
				output += "<td>" + address + "</td>";
				output += "<td>" + capacity + "</td>";
				
				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"
						+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-itemid='"
						+ id + "'>" + "</td></tr>";
			}
			con.close();
			
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the power plants.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String insertPowerPlant(String name, String type, String address, String capacity) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			
			// create a prepared statement
			String query = " insert into powerplants (`id`,`name`,`type`,`address`,`capacity`)"
					+ " values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, name);
			preparedStmt.setString(3, type);
			preparedStmt.setString(4, address);
			preparedStmt.setString(5, capacity);
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newPowerPlants = readPowerPlants();
			output = "{\"status\":\"success\", \"data\": \"" + newPowerPlants + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while inserting the item.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updatePowerPlant(String id, String name, String type, String address, String capacity) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE items SET itemCode=?,itemName=?,itemPrice=?,itemDesc=? WHERE itemID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, name);
			preparedStmt.setString(2, type);
			preparedStmt.setString(3, address);
			preparedStmt.setString(4, capacity);
			preparedStmt.setInt(5, Integer.parseInt(id));

			// execute the statement
			preparedStmt.execute();
			con.close();
			String newPowerPlants = readPowerPlants();
			output = "{\"status\":\"success\", \"data\": \"" + newPowerPlants + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while updating the power plant.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deletePowerPlant(String id) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from items where itemID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(id));
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newPowerPlants = readPowerPlants();
			output = "{\"status\":\"success\", \"data\": \"" + newPowerPlants + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while deleting the item.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}
}
