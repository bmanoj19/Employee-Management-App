package com.example.department_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.department_management.entity.dept;

@Repository
public interface dept_repo extends JpaRepository<dept, Integer>{

}
