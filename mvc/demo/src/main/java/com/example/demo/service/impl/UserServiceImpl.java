package com.example.demo.service.impl;

import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.TransactionTestException;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.IRoleService;
import com.example.demo.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final IRoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User create(User user, Integer roleId) {
        log.info("Creating user: {} with roleId: {}", user, roleId);
        if (user == null) {
            throw new BadRequestException("User cannot be null");
        }
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            throw new BadRequestException("User email cannot be null or empty");
        }
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new BadRequestException("User name cannot be null or empty");
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new BadRequestException("User with email " + user.getEmail() + " already exists");
        }
        if (roleId != null) {
            Optional<Role> role = roleService.findById(roleId);
            role.ifPresent(user::setRole);
        }
        if (user.getCreatedAt() == null) {
            user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        }
        if (user.getPassword() == null || user.getPassword().isBlank()) {
    throw new BadRequestException("Password is required");
}
user.setPassword(
    passwordEncoder.encode(user.getPassword())
);
        return userRepository.save(user);
    }

    @Override
    public Page<User> findAll(int page, int size, String sortBy, String direction) {
        log.info("Fetching users page: {}, size: {}, sortBy: {}, direction: {}", page, size, sortBy, direction);

        // Determinamos la dirección del ordenamiento de manera segura
        Sort.Direction sortDirection = direction.equalsIgnoreCase("desc")
                ? Sort.Direction.DESC
                : Sort.Direction.ASC;

        // Construimos el objeto Sort por la propiedad indicada
        Sort sort = Sort.by(sortDirection, sortBy);

        // Instanciamos el Pageable combinando página, tamaño y orden
        Pageable pageable = PageRequest.of(page, size, sort);

        // Ejecutamos la consulta en el repositorio
        return userRepository.findAll(pageable);
    }

    @Override
    public List<User> findAll() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        log.info("Finding user by id: {}", id);
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        log.info("Finding user by email: {}", email);
        return userRepository.findByEmail(email);
    }

    @Override
    public User update(Integer id, User user, Integer roleId) {
        log.info("Updating user id: {} with data: {}, roleId: {}", id, user, roleId);
        if (id == null) {
            throw new BadRequestException("User id cannot be null");
        }
        if (user == null) {
            throw new BadRequestException("User cannot be null");
        }

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        if (user.getEmail() != null && !user.getEmail().trim().isEmpty()) {
            Optional<User> userWithSameEmail = userRepository.findByEmail(user.getEmail());
            if (userWithSameEmail.isPresent() && !userWithSameEmail.get().getId().equals(id)) {
                throw new BadRequestException("User with email " + user.getEmail() + " already exists");
            }
            existingUser.setEmail(user.getEmail());
        }

        if (user.getName() != null && !user.getName().trim().isEmpty()) {
            existingUser.setName(user.getName());
        }
if (user.getPassword() != null
        && !user.getPassword().isBlank()) {

    existingUser.setPassword(
        passwordEncoder.encode(user.getPassword())
    );
}
        if (roleId != null) {
            Role role = roleService.findById(roleId)
                    .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + roleId));
            existingUser.setRole(role);
        }

        existingUser.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteById(Integer id) {
        log.info("Deleting user by id: {}", id);
        if (id == null) {
            throw new BadRequestException("User id cannot be null");
        }
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<User> saveAllUsers(List<User> users) throws TransactionTestException {
        log.info("Saving list of {} users with transaction", users.size());
        for (User user : users) {
            // Simulamos una validación que lanza nuestra checked exception si el email contiene 'error' o 'fail'
            if (user.getEmail() != null && user.getEmail().contains("error")) {
                log.error("Error provocado al procesar usuario con email: {}", user.getEmail());
                throw new TransactionTestException("Fallo intencional para probar rollbackFor con TransactionTestException en: " + user.getEmail());
            }
            userRepository.save(user);
        }
        return users;
    }
}
