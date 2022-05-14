package com.eg.electrogrid.model;

public class powerplantmodel {
	private int id;
	private String Name;
	private String Type;
	private String Address;
	private String Capacity;
	public powerplantmodel() {
		super();
	}
	
	public powerplantmodel(int id, String name, String type, String address, String capacity) {
		super();
		this.id = id;
		this.Name = name;
		this.Type = type;
		this.Address = address;
		this.Capacity = capacity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCapacity() {
		return Capacity;
	}

	public void setCapacity(String capacity) {
		Capacity = capacity;
	}


}
