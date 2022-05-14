package com.eg.electrogrid.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.eg.electrogrid.model.powerplantmodel;



public class powerplantservice {
	Connection con;

	public powerplantservice() {

		try {
			String url =String.format("jdbc:mysql://localhost:3306/electrogrid");
			String uname ="root";
			String pwd = "";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pwd);
			
		} catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
}

	public powerplantmodel insertPowerplant(powerplantmodel powerplant) {
String insert = "insert into powerplant(id,name,type,address,capacity) values(?,?,?,?,?) ";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1, powerplant.getId());
			ps.setString(2, powerplant.getName());
			ps.setString(3, powerplant.getType());
			ps.setString(4, powerplant.getAddress());
			ps.setString(5, powerplant.getCapacity());
			
			ps.execute();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return powerplant;
		
	}

public ArrayList<powerplantmodel> getPowerplant() throws SQLException{
	
	ArrayList<powerplantmodel> data = new ArrayList<powerplantmodel>();
	
	String select = "select * from powerplant";
	PreparedStatement ps = con.prepareStatement(select);
	ResultSet rs = ps.executeQuery();
	
	while(rs.next()) {
		powerplantmodel model = new powerplantmodel();
		
		model.setId(rs.getInt("id"));// column name
		model.setName(rs.getString("name")); 
		model.setType(rs.getString("type"));
		model.setAddress(rs.getString("address"));
		model.setCapacity(rs.getString("capacity"));
		data.add(model);		
	}		
	return data;
		
}

public ArrayList<powerplantmodel> getPowerplantById(String id) throws SQLException{
	
	ArrayList<powerplantmodel> data = new ArrayList<powerplantmodel>();
	
	String select = "select * from powerplant where id = ?";
	PreparedStatement ps = con.prepareStatement(select);
	ps.setString(1, id);
	ResultSet rs = ps.executeQuery();
	
	while(rs.next()) {
		powerplantmodel model = new powerplantmodel();
		
		model.setId(rs.getInt("id"));// column name
		model.setName(rs.getString("name")); 
		model.setType(rs.getString("type"));
		model.setAddress(rs.getString("address"));
		model.setCapacity(rs.getString("capacity"));
	    data.add(model);		
	}		
	return data;
		
}

public powerplantmodel updatePowerplant(powerplantmodel powerplant) {
	String insert = "update powerplant set name=? , type=? , address=? , capacity=? where id =?";
	
	try {
		PreparedStatement ps = con.prepareStatement(insert);
		;
		ps.setString(1, powerplant.getName());
		ps.setString(2, powerplant.getType());
		ps.setString(3, powerplant.getAddress());
		ps.setString(4, powerplant.getCapacity());
		ps.setInt(5, powerplant.getId());
		
		ps.executeUpdate();
	}catch(Exception e) {
		System.out.println(e +"data insert unsuccess.");
	}
	
	return powerplant;
	
}


public int deletePowerplant(int id) {
	String insert = "delete from powerplant where id =?";
	
	try {
		PreparedStatement ps = con.prepareStatement(insert);
		ps.setInt(1,id);
		
		ps.executeUpdate();
	}catch(Exception e) {
		System.out.println(e +"data insert unsuccess.");
	}
	
	return id;

}


	}


