package com.example.demo.model;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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


      private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"routines", "activityLogs"})
    private User user; //FK
 private Timestamp createdAt;
    private Timestamp updatedAt;
    
    @OneToMany(mappedBy = "routine")
    @JsonIgnoreProperties("routine")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<ActivityLog> activityLogs;

    @OneToMany(mappedBy = "routine")
    @JsonIgnoreProperties("routine")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<RoutineExercise> routineExercises;
    
  
   
    
}
