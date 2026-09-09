package com.example.demo.model;

import java.sql.Timestamp;

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
@Table(name="routines")
public class Routine {


    @Id 
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private int id;

    private int userId;//FK
    
    private String name;
    private String description;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    
    
}
