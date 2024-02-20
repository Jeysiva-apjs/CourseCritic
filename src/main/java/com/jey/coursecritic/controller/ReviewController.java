package com.jey.coursecritic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jey.coursecritic.entity.Review;
import com.jey.coursecritic.service.ReviewService;

@RestController
@RequestMapping("user/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/add")
    public void addReview(@RequestBody Review reviewRequest){
        reviewService.addReview(reviewRequest);
    }

    @GetMapping("/find")
    public Review getReview(@RequestParam Long reviewId){
        return reviewService.getReviewById(reviewId);
    }
}
