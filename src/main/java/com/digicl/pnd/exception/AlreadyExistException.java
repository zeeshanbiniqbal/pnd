package com.digicl.pnd.exception;

@SuppressWarnings("serial")
public class AlreadyExistException extends RuntimeException{
	
	public AlreadyExistException(String message){
        super(message);
    }
}
