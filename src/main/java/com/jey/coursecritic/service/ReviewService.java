package com.jey.coursecritic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jey.coursecritic.entity.Course;
import com.jey.coursecritic.entity.Review;
import com.jey.coursecritic.exception.ReviewNotFoundException;
import com.jey.coursecritic.repository.CourseRepository;
import com.jey.coursecritic.repository.ReviewRepository;


@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private CourseRepository courseRepository;

    public void addReview(Review review) {
        Course course=courseRepository.findById(review.getCourse().getId()).orElse(null);
        reviewRepository.save(review);

        if(course!=null) {
            Double average = reviewRepository.getReviewAverage(course.getId());
            course.setRating(average);
            courseRepository.save(course);
        }

    }

    public Review getReviewById(Long reviewId) {

        Review review= reviewRepository.findById(reviewId)
        .orElseThrow(() -> new ReviewNotFoundException(reviewId));

        return review;

    }
}
