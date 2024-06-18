package com.emp_manage.exception;

@SuppressWarnings("serial")
public class EmpAlreadyExistsException extends RuntimeException{
    public EmpAlreadyExistsException(String msg)
    {
        super(msg);
    }
}
