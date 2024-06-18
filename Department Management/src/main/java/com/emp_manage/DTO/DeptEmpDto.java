package com.emp_manage.DTO;

import java.util.List;

import com.emp_manage.entity.Emp;

public class DeptEmpDto {
	DeptDto d;
	List<Emp> e;
	
	public DeptDto getD() {
		return d;
	}

	public void setD(DeptDto d) {
		this.d = d;
	}

	public List<Emp> getE() {
		return e;
	}

	public void setE(List<Emp> e) {
		this.e = e;
	}

	@Override
	public String toString() {
		return "DeptEmpDto [d=" + d + ", e=" + e + "]";
	}

}
