package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="permissions")
public class Permission{

@Id 
@GeneratedValue (strategy=GenerationType.IDENTITY)    
private int id;

@OneToMany(mappedBy="permission")
private List<RolePermission> rolePermissions;
    
    
private String name;
private String description;



}