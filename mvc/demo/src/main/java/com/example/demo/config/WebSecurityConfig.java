package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        return http

            .authorizeHttpRequests(auth -> auth

                // Recursos que no necesitan login
                .requestMatchers(
                    "/css/**",
                    "/js/**",
                    "/images/**"
                ).permitAll()

                // Página pública de login
                .requestMatchers("/mvc/auth/login")
                    .permitAll()

                // Zona para administradores
                .requestMatchers("/mvc/admin/**")
                    .hasRole("ADMIN")

                // Crear, editar y eliminar usuarios
                .requestMatchers(
                    "/mvc/users/add",
                    "/mvc/users/edit/**",
                    "/mvc/users/delete/**"
                ).hasAuthority("USER_WRITE")

                // Todas las demás rutas necesitan login
                .anyRequest().authenticated()
            )

            .formLogin(form -> form

                .loginPage("/mvc/auth/login")

                .loginProcessingUrl("/mvc/auth/login")

                .usernameParameter("username")

                .passwordParameter("password")

                .defaultSuccessUrl("/mvc/users", true)

                .failureUrl("/mvc/auth/login?error=true")

                .permitAll()
            )

            .logout(logout -> logout

                .logoutUrl("/logout")

                .logoutSuccessUrl("/mvc/auth/login?logout=true")

                .invalidateHttpSession(true)

                .deleteCookies("JSESSIONID")

                .permitAll()
            )

            .build();
    }
}
