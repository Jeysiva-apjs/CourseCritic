package com.jey.coursecritic.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jey.coursecritic.constants.CourseGenre;
import com.jey.coursecritic.entity.Course;
import com.jey.coursecritic.exception.CourseNotFoundException;
import com.jey.coursecritic.repository.CourseRepository;

import java.util.*;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course findCourse(String title) {

        Course course = courseRepository.findByTitle(title);
        if (course == null)
            throw new CourseNotFoundException(title);
        return course;
    }

    public List<Course> findCoursesByGenre(String genre) {
        if (Arrays.stream(CourseGenre.values()).noneMatch(g -> g.toString().equals(genre)))
            throw new CourseNotFoundException(genre);
        List<Course> courseList = courseRepository.findByGenre(CourseGenre.valueOf(genre));
        return courseList;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }


}
