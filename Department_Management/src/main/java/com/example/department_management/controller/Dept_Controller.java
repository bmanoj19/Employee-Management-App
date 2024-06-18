package com.example.department_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.department_management.entity.dept;
import com.example.department_management.service.DeptServiceImpl;

@RestController
public class Dept_Controller {
	
	@Autowired
	DeptServiceImpl ds;
	
	@PostMapping("dept")
	public dept savedept(@RequestBody dept d) {
		return ds.savedept(d);
	}
	
	@GetMapping("dept/{dept_id}")
	public dept getdept(@PathVariable("dept_id") int dept_id) {
		return ds.getdept(dept_id);
	}
	
	@GetMapping("depts")
	public List<dept> getAll(){
		return ds.getAll();
	}
}
