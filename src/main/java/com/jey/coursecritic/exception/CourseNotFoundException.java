package com.jey.coursecritic.exception;

public class CourseNotFoundException extends RuntimeException{

    public CourseNotFoundException(Long id){
        super("Could not find course with id " + id + ".");
    }

    public CourseNotFoundException(String title){
        super("Could not find course with title " + title + ".");
    }
    
}
