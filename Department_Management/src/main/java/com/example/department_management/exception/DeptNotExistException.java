package com.example.department_management.exception;

@SuppressWarnings("serial")
public class DeptNotExistException extends RuntimeException{
	public DeptNotExistException(String msg) {
		super(msg);
	}
}
