package com.jey.coursecritic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jey.coursecritic.entity.Admin;
import com.jey.coursecritic.entity.Course;
import com.jey.coursecritic.service.AdminService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody Admin admin) {  
        return new ResponseEntity<>(adminService.createAdmin(admin), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody Admin admin) {
       return new ResponseEntity<>(adminService.loginAdmin(admin.getName(), admin.getPassword()), 
       HttpStatus.OK);
    }

    @PostMapping("course/add")
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        return new ResponseEntity<>(adminService.addcourse(course), HttpStatus.CREATED);
    }

    @PostMapping("course/remove/{courseId}")
    public ResponseEntity<String> removeCourse(@PathVariable Long courseId){
        return new ResponseEntity<>(adminService.removecourse(courseId), HttpStatus.OK);
    }

}
