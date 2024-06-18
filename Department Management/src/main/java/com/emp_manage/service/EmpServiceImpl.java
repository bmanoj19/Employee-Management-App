package com.emp_manage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.emp_manage.DTO.DeptDto;
import com.emp_manage.DTO.DeptEmpDto;
import com.emp_manage.DTO.ResponseDto;
import com.emp_manage.entity.Emp;
import com.emp_manage.exception.EmpAlreadyExistsException;
import com.emp_manage.exception.NoEmpExistException;
import com.emp_manage.exception.UpdateException;
import com.emp_manage.repo.EmpRepo;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	EmpRepo repo;
	@Autowired
	RestTemplate rt;

	@Override
	public Emp adding(Emp e) throws EmpAlreadyExistsException{
		Emp s = repo.findById(e.getId()).orElse(null);
		if(s == null) {
			return repo.save(e);
		}
		else
			throw new EmpAlreadyExistsException("Employee Already Exists");
	}

	@Override
	public Emp getemp(int id) throws NoEmpExistException{
			Emp e = repo.findById(id).orElseThrow(()-> new NoEmpExistException("Employee not Exist with id "+id));
			return e;
	}
	
	@Override
	public List<Emp> getall() {
		return repo.findAll();
	}

	@Override
	public Emp delemp(int id) throws NoEmpExistException{
		Emp e = repo.findById(id).orElseThrow(()-> new NoEmpExistException("Employee not Exist with id "+id));
		repo.deleteById(id);
		return e;
	}

	@Override
	public Emp update(Emp e) throws UpdateException, NoEmpExistException{
		Emp c = repo.findById(e.getId()).orElse(null);
		if(c != null) {
			if((c.getName()).compareTo(e.getName()) == 0)
				return repo.save(e);
			else
				throw new UpdateException("Can't update the name of the Employee");
		}
		else
			throw new NoEmpExistException("Employee with id "+e.getId()+" not Exist");
	}

	@Override
	public Emp getempbyname(String name) throws NoEmpExistException{
		Emp e = repo.findByName(name);
		if(e != null)
			return e;
		else
			throw new NoEmpExistException("Employee not Exist with name "+name);
	}

	@Override
	public ResponseDto getEmpDept(int id) {
		Emp Employee = repo.findById(id).orElseThrow(()->new NoEmpExistException("No Employee with exist with Id "+id));
		ResponseDto result = new ResponseDto();
		result.setEmployee(Employee);
		ResponseEntity<DeptDto> Department = rt.getForEntity("http://localhost:8081/dept/"+Employee.getDept_id(), DeptDto.class);
		result.setDepartment(Department.getBody());
		return result;
	}

	@Override
	public List<ResponseDto> getemps() {
		List<Emp> Employee = repo.findAll();
		List<ResponseDto> response = new ArrayList<>();
		for(int i=0;i<Employee.size();i++) {
			ResponseDto temp = new ResponseDto();
			temp.setEmployee(Employee.get(i));
			ResponseEntity<DeptDto> Department = rt.getForEntity("http://localhost:8081/dept/"+Employee.get(i).getDept_id(), DeptDto.class);
			temp.setDepartment(Department.getBody());
			response.add(temp);
		}
		return response;
	}

	@Override
	public List<Emp> getemploy(int deptid) {
		return repo.findByDeptid(deptid);
	}

	@Override
	public List<DeptEmpDto> getdeptemp() {
		ResponseEntity<DeptDto[]> d = rt.getForEntity("http://localhost:8081/depts", DeptDto[].class);
		DeptDto[] de = d.getBody();
		List<DeptEmpDto> response = new ArrayList<>();
		for(int i=0;i<de.length;i++) {
			DeptEmpDto temp = new DeptEmpDto();
			temp.setD(de[i]);
			temp.setE(repo.findByDeptid(de[i].getDept_id()));
			response.add(temp);
		}
		return response;
	}
	
}
