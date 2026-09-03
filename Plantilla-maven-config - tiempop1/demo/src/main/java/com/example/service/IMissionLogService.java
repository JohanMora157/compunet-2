package com.example.service;

import java.util.List;

import com.example.model.MissionLog;

public interface  IMissionLogService {
        MissionLog save(MissionLog missionLog);

    MissionLog find(int id);

    List<MissionLog> list();
}
