package com.libo.beans;

public class Admin extends User { // IS A realtionship

//	private Roles role = Roles.ADMIN;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public Admin(int id, String name, String password) {
		super(id, name, password, Roles.ADMIN);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Admin [name=" + name + ", id=" + id + ", getName()=" + getName() + ", getId()=" + getId()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

}
