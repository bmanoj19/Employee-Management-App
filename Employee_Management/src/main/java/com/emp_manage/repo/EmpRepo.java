package com.emp_manage.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp_manage.entity.Emp;


@Repository
public interface EmpRepo extends JpaRepository<Emp, Integer> {
	public Emp findByName(String name);
	public List<Emp> findByDeptid(int deptid);
}
