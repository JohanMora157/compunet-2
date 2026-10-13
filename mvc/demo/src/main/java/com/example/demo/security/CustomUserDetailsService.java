
package com.example.demo.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.service.IUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        Optional<User> user = userService.findByEmail(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException(
                "Usuario no encontrado"
            );
        }

        return new CustomUserDetails(user.get());
    }
}
