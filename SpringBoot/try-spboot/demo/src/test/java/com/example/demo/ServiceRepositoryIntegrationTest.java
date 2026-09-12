package com.example.demo;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.IRoleService;
import com.example.demo.service.IUserService;

@SpringBootTest
class ServiceRepositoryIntegrationTest {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IUserService userService;

    @Test
    void testCreateAndFindRoleAndUser() {
        Role role = Role.builder()
                .name("ADMIN")
                .build();
        Role savedRole = roleService.save(role);
        assertNotNull(savedRole);
        assertTrue(savedRole.getId() > 0);

        User user = User.builder()
                .name("Carlos")
                .email("carlos@example.com")
                .password("secret123")
                .role(savedRole)
                .build();
        User savedUser = userService.save(user);
        assertNotNull(savedUser);
        assertTrue(savedUser.getId() > 0);

        Optional<User> found = userService.findByEmail("carlos@example.com");
        assertTrue(found.isPresent());
        assertEquals("Carlos", found.get().getName());
        assertEquals("ADMIN", found.get().getRole().getName());
    }

    @Test
    void testDataSqlLoaded() {
        Optional<User> user = userService.findByEmail("carlos@gym.com");
        assertTrue(user.isPresent());
        assertEquals("Carlos Gomez", user.get().getName());
        assertNotNull(user.get().getRole());
        assertEquals("ADMIN", user.get().getRole().getName());

        Optional<Role> coachRole = roleService.findByName("ENTRENADOR");
        assertTrue(coachRole.isPresent());
    }
}
