package com.example.department_management.exception;

@SuppressWarnings("serial")
public class DeptAlreadyExistsException extends RuntimeException{
	public DeptAlreadyExistsException(String msg){
		super(msg);
	}
}
