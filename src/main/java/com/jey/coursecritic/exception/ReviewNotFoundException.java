package com.jey.coursecritic.exception;

public class ReviewNotFoundException extends RuntimeException{

    public ReviewNotFoundException(Long id){
        super("Could not find review with id " + id + ".");
    }
    
}
