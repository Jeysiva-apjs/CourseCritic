package com.jey.coursecritic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jey.coursecritic.entity.Review;


@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

    @Query(value = "select avg(rating) from review_table where course_id=?",nativeQuery = true)
    Double getReviewAverage(Long id);
}
