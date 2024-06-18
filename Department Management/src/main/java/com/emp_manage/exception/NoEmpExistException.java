package com.emp_manage.exception;

@SuppressWarnings("serial")
public class NoEmpExistException extends RuntimeException{
    public NoEmpExistException(String msg)
    {
        super(msg);
    }
}
