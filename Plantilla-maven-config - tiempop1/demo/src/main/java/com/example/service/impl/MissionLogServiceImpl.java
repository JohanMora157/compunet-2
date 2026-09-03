package com.example.service.impl;

import java.util.List;

import com.example.model.MissionLog;
import com.example.repository.IMissionLogRepositoty;
import com.example.repository.IStarshipRepositoty;
import com.example.service.IMissionLogService;

public class MissionLogServiceImpl implements IMissionLogService {
    private IMissionLogRepositoty missionLogRepositoty;
        private IStarshipRepositoty starshipRepositoty;


    public MissionLogServiceImpl(IMissionLogRepositoty missionLogRepositoty,IStarshipRepositoty starshipRepositoty) {
        this.missionLogRepositoty = missionLogRepositoty;
        this.starshipRepositoty= starshipRepositoty;
    }

    @Override
    public MissionLog save(MissionLog missionLog) {

        for(MissionLog m: missionLogRepositoty.list()){


    if((missionLog.getLogCode() == m.getLogCode())&&(missionLog!=m)){

throw new IllegalArgumentException("ya hay otra mission con el LogCode"); 

}
    }

    if(!(missionLog.getThreatLevel()>0 && missionLog.getThreatLevel()<11 )){

throw new IllegalArgumentException("el valor debe de estar entre 1 y 10"); 

    }

if(starshipRepositoty.find(missionLog.getStarshipId())==null){

    throw new IllegalArgumentException("la nave no existe"); 


}
if(starshipRepositoty.find(missionLog.getStarshipId()).getStatus().equals("Decommissioned")){

    throw new IllegalArgumentException("la nave no existe"); 


}

        return  missionLogRepositoty.save(missionLog);

}

    @Override
    public MissionLog find(int id) {
        return missionLogRepositoty.find(id);
    }

    @Override
    public List<MissionLog> list() {
        return missionLogRepositoty.list();
    }
    
}
