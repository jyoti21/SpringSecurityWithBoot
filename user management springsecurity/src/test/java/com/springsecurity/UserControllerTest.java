package com.springsecurity;

import com.springsecurity.controller.UserControllerDB;
import com.springsecurity.entity.UserEntity;
import com.springsecurity.repository.UserRepository;
import com.springsecurity.service.UserServiceDB;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @InjectMocks
    private UserControllerDB userController;

    @Mock
    private UserServiceDB userServiceDB;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testGetAllUsers() {
        UserEntity user1 = UserEntity.builder().userName("abc").password("abc123").role("ROLE_NORMAL").build();
        UserEntity user2 = UserEntity.builder().userName("xyz").password("xyz123").role("ROLE_ADMIN").build();
        // Mocking behavior
        List<UserEntity> mockUsers = new ArrayList<>();
        mockUsers.add(user1);
        mockUsers.add(user2);

        Mockito.when(userServiceDB.getAllUsers()).thenReturn(mockUsers);

        // Perform the test
        List<UserEntity> users = userController.getAllUsers();

        // Assertions
        assertNotNull(users);
        assertEquals(2, users.size());
        // Add more assertions based on the expected behavior
    }

    @Test
    public void testGetUserByUserName() {
        // Mocking behavior
        String username = "abc";
        UserEntity mockUser = UserEntity.builder().userName("abc").password("abc123").role("ROLE_NORMAL").build();

        Mockito.when(userServiceDB.getUserByUserName(username)).thenReturn(mockUser);

        // Perform the test
        UserEntity user = userController.getUserByUserName(username);

        // Assertions
        assertNotNull(user);
        // Add more assertions based on the expected behavior
    }

    @Test
    public void testAddUser() {
        // Mocking behavior
        UserEntity userToAdd = UserEntity.builder().userName("abc").password("abc123").role("ROLE_NORMAL").build();
        Mockito.when(userServiceDB.addUser(Mockito.any(UserEntity.class))).thenReturn(userToAdd);

        // Perform the test
        UserEntity addedUser = userController.addUser(userToAdd);

        // Assertions
        assertNotNull(addedUser);
        // Add more assertions based on the expected behavior
    }

    @Test
    public void testDeleteUser() {
        // Mocking behavior
        long userIdToDelete = 1L;
        UserEntity userToDelete = UserEntity.builder().userName("abc").password("abc123").role("ROLE_NORMAL").build();
        Mockito.when(userRepository.findById(userIdToDelete)).thenReturn(Optional.of(userToDelete));

        // Perform the test
        String result = userController.deleteUser(userIdToDelete);

        // Assertions
        assertNotNull(result);
        assertEquals("Successfully deleted", result);
        // Add more assertions based on the expected behavior
    }

    @Test
    public void testGetMessage() {
        // Perform the test
        String message = userController.getMessage();

        // Assertions
        assertNotNull(message);
        assertEquals("this is an private api", message);
        // Add more assertions based on the expected behavior
    }
}