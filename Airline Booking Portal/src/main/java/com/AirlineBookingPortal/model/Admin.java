package com.AirlineBookingPortal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {

	@Id
	private String Email;
	private String Name;
	private String password;

	public Admin() {
	}

	public Admin(String email, String name, String password) {
		Email = email;
		Name = name;
		this.password = password;
	}

	
	public String getUsername() {
		return Email;
	}

	public void setUsername(String username) {
		Email = username;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [Email=" + Email + ", Name=" + Name + ", password=" + password + "]";
	}
	
	
}
