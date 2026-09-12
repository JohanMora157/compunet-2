package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data //para hacer get y set auto
@Builder //crea el objeto de la forma: Role role = Role.builder().name("ADMIN").build();
@NoArgsConstructor // genera un constructor vacio
@AllArgsConstructor// genera un constructor con todos los atributos
@Entity //hace que se persista en la base de datos
@Table(name = "roles")// asigna nombre a la tabla
public class Role {


@Id // dice que este atributo es PK
@GeneratedValue(strategy = GenerationType.IDENTITY) //genera ese id automaticamente en secuencia
private int id;

@OneToMany(mappedBy="role")
@JsonIgnoreProperties("role")
@ToString.Exclude
@EqualsAndHashCode.Exclude
private List<User> users;

@OneToMany(mappedBy="role")
@JsonIgnoreProperties("role")
@ToString.Exclude
@EqualsAndHashCode.Exclude
private List<RolePermission> rolePermissions;
    
    
    
private String name;


    
}
