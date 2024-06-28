package com.week2.lms.Exceptions;

public class NotAIntegerException extends RuntimeException{

    public NotAIntegerException(){
        super();
    }

    public NotAIntegerException(String msg){
        super(msg);
    }
}