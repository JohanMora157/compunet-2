package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "permissions")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "permission")
    private List<RolePermission> rolePermissions;

    /*
    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles;
    */
}
