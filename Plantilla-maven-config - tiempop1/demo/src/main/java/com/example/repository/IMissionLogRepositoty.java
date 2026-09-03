package com.example.repository;

import java.util.List;

import com.example.model.MissionLog;

public interface  IMissionLogRepositoty {

    
    void init();

    MissionLog save(MissionLog missionLog);

    MissionLog find(int id);

    List<MissionLog> list();
    
}
