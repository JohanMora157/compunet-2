package com.example.demo.model;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @ManyToOne
    @JoinColumn(name = "role_id")   //el join colum siempre va con "name", cuando es uno va con ManyToOne
    private Role role; //FK

    @OneToMany(mappedBy = "user")
    private List<Routine> routines;

    @OneToMany(mappedBy = "user")
    private List<ActivityLog> activityLogs; // la lista siempre va con OneToMany

    private String name;

    @Column(unique = true, nullable = false)// unico y no nulo
    private String email;

    private String password;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    
    
}
