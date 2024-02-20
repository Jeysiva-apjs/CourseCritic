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

// import com.jey.coursecritic.entity.User;
// import com.jey.coursecritic.exception.UserNotFoundException;
// import com.jey.coursecritic.repository.UserRepository;
// import com.jey.coursecritic.service.UserService;

// public class UserServiceTest {

//     @Mock
//     private UserRepository userRepository;

//     @InjectMocks
//     private UserService userService;

//     @BeforeEach
//     public void setup() {
//         MockitoAnnotations.openMocks(this);
//     }

//     @Test
//     public void testCreateUser() {
//         User user = new User();
//         when(userRepository.save(user)).thenReturn(user);

//         String result = userService.createUser(user);

//         assertEquals("User created successfully", result);
//         verify(userRepository, times(1)).save(user);
//     }

//     @Test
//     public void testLoginUser() {
//         String name = "user";
//         String password = "password";

//         List<User> users = new ArrayList<>();
//         User user = new User();
//         user.setName(name);
//         user.setPassword(password);
//         users.add(user);

//         when(userRepository.findAll()).thenReturn(users);

//         String result = userService.loginUser(name, password);

//         assertEquals("Logged in successfully", result);
//     }

//     @Test
//     public void testLoginUser_UserNotFound() {
//         String name = "user";
//         String password = "password";

//         List<User> users = new ArrayList<>();

//         when(userRepository.findAll()).thenReturn(users);

//         assertThrows(UserNotFoundException.class, () -> {
//             userService.loginUser(name, password);
//         });
//     }

//     @Test
//     public void testLoginUser_IncorrectPassword() {
//         String name = "user";
//         String password = "password";

//         List<User> users = new ArrayList<>();
//         User user = new User();
//         user.setName(name);
//         user.setPassword("wrongpassword");
//         users.add(user);

//         when(userRepository.findAll()).thenReturn(users);

//         assertThrows(UserNotFoundException.class, () -> {
//             userService.loginUser(name, password);
//         });
//     }
// }