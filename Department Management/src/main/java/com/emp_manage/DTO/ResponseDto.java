package com.emp_manage.DTO;

import com.emp_manage.entity.Emp;

public class ResponseDto {
	DeptDto Department;
	public DeptDto getDepartment() {
		return Department;
	}
	public void setDepartment(DeptDto d) {
		this.Department = d;
	}
	Emp Employee;
	public void setEmployee(Emp e) {
		this.Employee = e;
	}
	public Emp getEmployee() {
		return Employee;
	}
	@Override
	public String toString() {
		return "[Emp "+ Employee + ", Dept" + Department + "]";
	}
}
