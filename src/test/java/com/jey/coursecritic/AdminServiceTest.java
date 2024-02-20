// package com.jey.coursecritic;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.mockito.Mockito.*;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;

// import com.jey.coursecritic.entity.Admin;
// import com.jey.coursecritic.entity.Course;
// import com.jey.coursecritic.exception.AdminNotFoundException;
// import com.jey.coursecritic.repository.AdminRepository;
// import com.jey.coursecritic.repository.CourseRepository;
// import com.jey.coursecritic.service.AdminService;

// public class AdminServiceTest {

//     @Mock
//     private CourseRepository courseRepository;

//     @Mock
//     private AdminRepository adminRepository;

//     @InjectMocks
//     private AdminService adminService;

//     @BeforeEach
//     public void setup() {
//         MockitoAnnotations.openMocks(this);
//     }

//     @Test
//     public void testAddCourse() {
//         Course course = new Course();
//         when(courseRepository.save(course)).thenReturn(course);

//         Course result = adminService.addcourse(course);

//         assertEquals(course, result);
//         verify(courseRepository, times(1)).save(course);
//     }

//     @Test
//     public void testRemoveCourse() {
//         Long courseId = 1L;

//         adminService.removecourse(courseId);

//         verify(courseRepository, times(1)).deleteById(courseId);
//     }

//     @Test
//     public void testCreateAdmin() {
//         Admin admin = new Admin();
//         when(adminRepository.save(admin)).thenReturn(admin);

//         String result = adminService.createAdmin(admin);

//         assertEquals("Admin created successfully", result);
//         verify(adminRepository, times(1)).save(admin);
//     }

//     @Test
//     public void testLoginAdmin() {
//         String name = "admin";
//         String password = "password";

//         List<Admin> admins = new ArrayList<>();
//         Admin admin = new Admin();
//         admin.setName(name);
//         admin.setPassword(password);
//         admins.add(admin);

//         when(adminRepository.findAll()).thenReturn(admins);

//         String result = adminService.loginAdmin(name, password);

//         assertEquals("Logged in successfully", result);
//     }

//     @Test
//     public void testLoginAdmin_AdminNotFound() {
//         String name = "admin";
//         String password = "password";

//         List<Admin> admins = new ArrayList<>();

//         when(adminRepository.findAll()).thenReturn(admins);

//         assertThrows(AdminNotFoundException.class, () -> {
//             adminService.loginAdmin(name, password);
//         });
//     }

//     @Test
//     public void testLoginAdmin_IncorrectPassword() {
//         String name = "admin";
//         String password = "password";

//         List<Admin> admins = new ArrayList<>();
//         Admin admin = new Admin();
//         admin.setName(name);
//         admin.setPassword("wrongpassword");
//         admins.add(admin);

//         when(adminRepository.findAll()).thenReturn(admins);

//         assertThrows(AdminNotFoundException.class, () -> {
//             adminService.loginAdmin(name, password);
//         });
//     }
// }