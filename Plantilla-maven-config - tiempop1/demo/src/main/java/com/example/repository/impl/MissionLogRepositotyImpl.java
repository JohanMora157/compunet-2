package com.example.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.model.MissionLog;
import com.example.repository.IMissionLogRepositoty;

public class MissionLogRepositotyImpl implements IMissionLogRepositoty {

    private List<MissionLog> missions = new ArrayList<>();
    private int countId=0;

   @Override
    public void init() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public MissionLog save(MissionLog missionLog) {

        if(missionLog == null){
            return  null;
        }else{

            missionLog.setId(countId++);
            missions.add(missionLog);

            return missionLog;
        }

    } 

    @Override
    public MissionLog find(int id) {

        for(MissionLog m: missions){
            if (m.getId()==id) {

                return m;
                
            }
        }   

        return null;

    }

    @Override
    public List<MissionLog> list() {
return missions;
    }


    
}
