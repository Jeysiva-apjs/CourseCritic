// package com.jey.coursecritic;
// @Test
// public void testFindCourse() {
//     String title = "Java Programming";

//     Course course = new Course();
//     course.setTitle(title);

//     when(courseRepository.findByTitle(title)).thenReturn(course);

//     Course result = courseService.findCourse(title);

//     assertEquals(course, result);
//     verify(courseRepository, times(1)).findByTitle(title);
// }

// @Test
// public void testFindCourse_CourseNotFound() {
//     String title = "Non-existent Course";

//     when(courseRepository.findByTitle(title)).thenReturn(null);

//     assertThrows(CourseNotFoundException.class, () -> {
//         courseService.findCourse(title);
//     });
// }