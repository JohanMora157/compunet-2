package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="role_permissions")
public class RolePermission {

    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
 
    @ManyToOne
    @JoinColumn(name = "role_id")
    @JsonIgnoreProperties({"rolePermissions", "users"})
    private Role role; //FK   

    @ManyToOne
    @JoinColumn(name = "permission_id")
    @JsonIgnoreProperties("rolePermissions")
    private Permission permission; //FK
}
