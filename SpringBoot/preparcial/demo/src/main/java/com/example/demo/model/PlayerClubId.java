package com.example.demo.model;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class PlayerClubId implements Serializable {

    @Column(name = "player_id")
    private Long playerId;

    @Column(name = "club_id")
    private Long clubId;

    @Column(name = "start_date")
    private Timestamp startDate;
}
