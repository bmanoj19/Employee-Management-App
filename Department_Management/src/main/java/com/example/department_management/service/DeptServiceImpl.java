package com.example.department_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.department_management.entity.dept;
import com.example.department_management.exception.DeptAlreadyExistsException;
import com.example.department_management.exception.DeptNotExistException;
import com.example.department_management.repo.dept_repo;

@Service
public class DeptServiceImpl implements Dept_service {
	@Autowired
	dept_repo repo;
	
	@Override
	public dept savedept(dept d) {
		dept e = repo.findById(d.getDept_id()).orElse(null);
		if(e == null)
			return repo.save(d);
		else
			throw new DeptAlreadyExistsException("Department Already Exists");
	}

	@Override
	public dept getdept(int dept_id) {
		return repo.findById(dept_id).orElseThrow(()-> new DeptNotExistException("Department Not Exists"));
	}

	@Override
	public List<dept> getAll() {
		return repo.findAll();
	}

}
