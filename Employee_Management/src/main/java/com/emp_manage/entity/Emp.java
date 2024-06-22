package com.emp_manage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Emp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	String city, email;
	int deptid;

	public Emp(int id, String name, String city, String email, int deptid) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.email = email;
		this.deptid = deptid;
	}

	public int getId() {
		return id;
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getdeptid() {
		return deptid;
	}

	public void setdeptid(int deptid) {
		this.deptid = deptid;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", city=" + city + ", email=" + email + "]";
	}


}
