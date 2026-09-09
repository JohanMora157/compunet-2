package com.example.demo.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private Role roleId; //FK


    private String name;

    @Column(unique = true, nullable = false)// unico y no nulo
    private String email;

    private String password;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    
    
}
