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
@Table(name = "activity_logs")
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"activityLogs", "routines"})
    private User user; //FK

    @ManyToOne
    @JoinColumn(name = "routine_id")
    @JsonIgnoreProperties({"activityLogs", "routineExercises"})
    private Routine routine; //FK


    @OneToMany(mappedBy = "activityLog")
    @JsonIgnoreProperties("activityLog")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<ActivityExercise> activityExercise;

    private Timestamp startedAt;

    private Timestamp completedAt;

    private Timestamp createdAt;

    
}