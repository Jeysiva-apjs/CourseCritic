package com.jey.coursecritic.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.jey.coursecritic.entity.Admin;
import com.jey.coursecritic.entity.Course;
import com.jey.coursecritic.exception.AdminNotFoundException;
import com.jey.coursecritic.repository.AdminRepository;
import com.jey.coursecritic.repository.CourseRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminService {

    private CourseRepository courseRepository;
    AdminRepository adminRepository;

    public Course addCourse(Course course){
        return courseRepository.save(course);
    }

    public String removeCourse(Long courseId) {
        courseRepository.deleteById(courseId);
        return "course removed successfully";
    }

    public String updateCourse(Course course) {
        courseRepository.findById(course.getId()).orElseThrow(() -> new AdminNotFoundException("Course"));
        courseRepository.save(course);
        return "course updated successfully";
    }

    public String createAdmin(Admin admin) {
        adminRepository.save(admin);
        return "Admin created successfully";
    }

    public String loginAdmin(String name, String password) {
        List<Admin> admins = (List<Admin>)adminRepository.findAll();
        if(admins.isEmpty()){
            throw new AdminNotFoundException(name);
        }
        Admin admin = admins.stream().filter(a -> a.getName().equals(name) 
        && a.getPassword().equals(password)).findFirst().orElse(null);

        if(admin == null){
            throw new AdminNotFoundException(name);
        }
        return "Logged in successfully";
    }
}
