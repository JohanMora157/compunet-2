// package com.example.teacher.model;

// import com.fasterxml.jackson.annotation.JsonIgnore;
// import jakarta.persistence.EmbeddedId;
// import jakarta.persistence.Entity;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import lombok.*;

// @Data
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor
// @Entity(name = "role_permissions_compose")
// public class RolePermissionCompose {

//     @EmbeddedId
//     private RolePermissionPK id;

//     @ToString.Exclude
//     @JsonIgnore
//     @ManyToOne
//     @JoinColumn(name = "role_id")
//     private Role role;

//     @ToString.Exclude
//     @JsonIgnore
//     @ManyToOne
//     @JoinColumn(name = "permission_id")
//     private Permission permission;
// }
