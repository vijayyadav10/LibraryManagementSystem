package com.libo.beans;

public class Student extends User {

//	private Roles role = Roles.STUDENT; 
	
	// HAS-A realtion ship
	private Address address;
	
	
	
	public Student() {
		super();
	}

	public Student(int id, String name, String temporary, String permanent, String password) {
		super(id, name, password, Roles.STUDENT);
		address = new Address(temporary, permanent);
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
	
}

//student has address