package com.simplepayment.domain.exceptions;

public class UnprocessableEntityException extends Exception{
    public UnprocessableEntityException(String message){
        super(message);
    }
}
