// package com.jey.coursecritic;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.mockito.Mockito.*;

// import com.jey.coursecritic.entity.Course;
// import com.jey.coursecritic.entity.Review;
// import com.jey.coursecritic.exception.ReviewNotFoundException;
// import com.jey.coursecritic.repository.CourseRepository;
// import com.jey.coursecritic.repository.ReviewRepository;
// import com.jey.coursecritic.service.ReviewService;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;

// public class ReviewServiceTest {

//     @Mock
//     private ReviewRepository reviewRepository;

//     @Mock
//     private CourseRepository courseRepository;

//     @InjectMocks
//     private ReviewService reviewService;

//     @BeforeEach
//     public void setup() {
//         MockitoAnnotations.openMocks(this);
//     }

//     @Test
//     public void testAddReview() {
//         Review review = new Review();
//         Course course = new Course();
//         course.setId(1L);
//         review.setCourse(course);

//         when(courseRepository.findById(course.getId())).thenReturn(Optional.of(course));
//         when(reviewRepository.getReviewAverage(course.getId())).thenReturn(4.5);

//         reviewService.addReview(review);

//         verify(reviewRepository, times(1)).save(review);
//         verify(courseRepository, times(1)).save(course);
//         assertEquals(4.5, course.getRating());
//     }

//     @Test
//     public void testAddReview_CourseNotFound() {
//         Review review = new Review();
//         Course course = new Course();
//         course.setId(1L);
//         review.setCourse(course);

//         when(courseRepository.findById(course.getId())).thenReturn(Optional.empty());

//         reviewService.addReview(review);

//         verify(reviewRepository, times(1)).save(review);
//         verify(courseRepository, never()).save(course);
//     }

//     @Test
//     public void testGetReviewById() {
//         Long reviewId = 1L;
//         Review review = new Review();
//         review.setId(reviewId);

//         when(reviewRepository.findById(reviewId)).thenReturn(Optional.of(review));

//         Review result = reviewService.getReviewById(reviewId);

//         assertEquals(review, result);
//     }

//     @Test
//     public void testGetReviewById_ReviewNotFound() {
//         Long reviewId = 1L;

//         when(reviewRepository.findById(reviewId)).thenReturn(Optional.empty());

//         assertThrows(ReviewNotFoundException.class, () -> {
//             reviewService.getReviewById(reviewId);
//         });
//     }
// }