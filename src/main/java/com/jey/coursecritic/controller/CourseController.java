package com.jey.coursecritic.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jey.coursecritic.entity.Course;
import com.jey.coursecritic.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/title")
    public Course findcourse(@RequestParam  String title){
        return courseService.findCourse(title);
    }

    @GetMapping("/genre")
    public List<Course> findcourseByGenre(@RequestParam String genre){
        return courseService.findCoursesByGenre(genre);
    }

    @GetMapping("/all")
    public List<Course> getAllcourse(){
        return courseService.getAllCourses();
    }

}
