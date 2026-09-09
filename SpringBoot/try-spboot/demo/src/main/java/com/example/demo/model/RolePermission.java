package com.example.demo.model;

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
@Table(name="role_permissions")
public class RolePermission {

@Id 
@GeneratedValue (strategy=GenerationType.IDENTITY)
 private int id;
 
 private int roleId; //FK   
 private int permissionId; //FK
}
