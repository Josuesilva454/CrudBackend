package com.spring.demo.SpringBoot3.exception;

public class ResourceNotFoundException extends  RuntimeException {

    public  ResourceNotFoundException(Long id){
        super("O id não existe");
    }
}
