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
//String Description, String LogCode, String Sector, String StarDate, int StarshipId, int ThreatLevel, String Title, int id
missions.add(new MissionLog("aponzaa","1231231234","norte","oqwei",0,3,"toponza",countId++));
missions.add(new MissionLog("aponzaa1","12312123132","norte","oqwei",1,3,"toponza",countId++));

missions.add(new MissionLog("aponza2","1231231233415","sur","oqwei",2,3,"toponza",countId++));


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
