package com.example.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.IUserRepository;
import com.example.repository.impl.UserRepositoryImpl;
import com.example.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {

        return userRepository.findAll();
    }

    @Override
    public User save(User user) {

        return userRepository.save(user);
    }

}
