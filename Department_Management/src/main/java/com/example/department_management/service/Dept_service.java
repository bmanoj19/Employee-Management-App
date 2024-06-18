package com.example.department_management.service;

import java.util.List;

import com.example.department_management.entity.dept;

public interface Dept_service {
	public dept savedept(dept d);
	public dept getdept(int dept_id);
	public List<dept> getAll();
}
