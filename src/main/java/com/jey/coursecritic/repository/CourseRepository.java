package com.jey.coursecritic.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jey.coursecritic.constants.CourseGenre;
import com.jey.coursecritic.entity.Course;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    
    public Course findByTitle(String title);

    public List<Course> findByGenre(CourseGenre genre);

}
