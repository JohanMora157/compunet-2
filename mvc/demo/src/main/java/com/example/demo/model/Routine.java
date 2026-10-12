package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "routines")
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String name;

    private String description;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "routine", cascade = CascadeType.ALL)
    private List<RoutineExercise> routineExercises;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "routine", cascade = CascadeType.ALL)
    private List<ActivityLog> activityLogs;
}
