package com.example.department_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class dept {
	@Id
	int dept_id;
	String dept_name;
	public dept() {
		super();
		// TODO Auto-generated constructor stub
	}
	public dept(int dept_id, String dept_name) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	@Override
	public String toString() {
		return "dept [dept_id=" + dept_id + ", dept_name=" + dept_name + "]";
	}
	
}
