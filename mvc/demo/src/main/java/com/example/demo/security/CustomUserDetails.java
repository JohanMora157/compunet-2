
package com.example.demo.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.demo.model.Role;
import com.example.demo.model.RolePermission;
import com.example.demo.model.User;

import org.springframework.security.core.userdetails.UserDetails;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {

    private final User user;

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities = new ArrayList<>();

        Role role = user.getRole();

        if (role != null) {

            authorities.add(
                new SimpleGrantedAuthority("ROLE_" + role.getName())
            );

            if (role.getRolePermissions() != null) {

                for (RolePermission rp : role.getRolePermissions()) {
                    authorities.add(
                        new SimpleGrantedAuthority(
                            rp.getPermission().getName()
                        )
                    );
                }

            }
        }

        return authorities;
    }
}
