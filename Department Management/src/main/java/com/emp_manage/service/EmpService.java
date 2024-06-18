package com.emp_manage.service;

import java.util.List;

import com.emp_manage.DTO.DeptEmpDto;
import com.emp_manage.DTO.ResponseDto;
import com.emp_manage.entity.Emp;

public interface EmpService {
	public Emp adding(Emp e);

	public Emp getemp(int id);

	public Emp delemp(int id);

	public List<Emp> getall();

	public Emp update(Emp e);

	public Emp getempbyname(String name);
	
	public ResponseDto getEmpDept(int id);
	
	public List<ResponseDto> getemps();
	
	public List<Emp> getemploy(int deptid);
	
	public List<DeptEmpDto> getdeptemp();
}
