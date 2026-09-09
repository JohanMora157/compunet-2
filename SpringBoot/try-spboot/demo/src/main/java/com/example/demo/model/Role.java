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
    
    
private String name;
    
}
