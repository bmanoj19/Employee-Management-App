package com.emp_manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emp_manage.DTO.DeptEmpDto;
import com.emp_manage.DTO.ResponseDto;
import com.emp_manage.entity.Emp;
import com.emp_manage.service.EmpServiceImpl;

@RestController
public class EmpController {
	@Autowired
	EmpServiceImpl es;

	@PostMapping("emp")
	public Emp add(@RequestBody Emp e) {
		return es.adding(e);
	}
	
	@GetMapping("emp")
	public Emp getemp(@RequestParam("id") int id) {
		return es.getemp(id);
	}

	@GetMapping("emps")
	public List<Emp> getall() {
		return es.getall();
	}

	@GetMapping("empbyname/{name}")
	public Emp getbyname(@PathVariable("name") String name) {
		return es.getempbyname(name);
	}

	@DeleteMapping("emp")
	public Emp deleteemp(@RequestParam("id") int id) {
		return es.delemp(id);
	}

	@PutMapping("emp")
	public Emp update(@RequestBody Emp e) {
		return es.update(e);
	}
	
	@GetMapping("empdept")
	public ResponseDto getempdept(@RequestParam("id") int id) {
		return es.getEmpDept(id);
	}
	
	@GetMapping("allemp")
	public List<ResponseDto> getallemp(){
		return es.getemps();
	}
	
	@GetMapping("allemploy/{deptid}")
	public List<Emp> getdept(@PathVariable("deptid") int deptid){
		return es.getemploy(deptid);
	}
	
	@GetMapping("alldept")
	public List<DeptEmpDto> gets(){
		return es.getdeptemp();
	}
}
