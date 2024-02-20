package com.jey.coursecritic.entity;


import lombok.*;
import java.io.Serializable;
import java.util.List;

import com.jey.coursecritic.constants.CourseGenre;

import jakarta.persistence.*;

@Entity
@Table(name="course_table")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class Course implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private CourseGenre genre;

    private Double rating;// a single entity which is average rating of all reviews for a course

    @OneToMany(mappedBy="course")
    private List<Review> reviews;




}
