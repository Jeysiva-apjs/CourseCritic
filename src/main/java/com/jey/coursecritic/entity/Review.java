package com.jey.coursecritic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name="review_table", uniqueConstraints = @UniqueConstraint(columnNames = {"course_id", "user_id"}))
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Review {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Long id;

    private String courseReview;

    private double rating;  // rating dedicated to each review.

    @ManyToOne
    @JoinColumn(name="course_id", nullable=false)
    @JsonIgnore
    private Course course; // it will add foregion key in mysql table with <TABLE_NAME>_<ID_NAME> --> // course_course_id

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    @JsonIgnore
    private User user;

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date updatedDate;

}
