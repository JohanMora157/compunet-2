package com.example.service.impl;

import java.util.List;

import com.example.model.Starship;
import com.example.repository.IStarshipRepositoty;
import com.example.service.IStarshipService;

public class StarshipServiceImpl implements IStarshipService{

    private IStarshipRepositoty starshipRepositoty;

    public StarshipServiceImpl(IStarshipRepositoty starshipRepositoty) {
        this.starshipRepositoty = starshipRepositoty;
    }

    @Override
    public Starship save(Starship starship) {

        
for(Starship s: starshipRepositoty.list()){


    if(starship.getRegistryCode() == s.getRegistryCode()){

throw new IllegalArgumentException("ya hay otra nave con el registrycode"); 

}

}

if(!(starship.getRegistryCode().length()==8)){
    throw new IllegalArgumentException("el registry code debe contener exactamente 8 chars"); 

}





return starshipRepositoty.save(starship);    }

    @Override
    public Starship find(int id) {
        return starshipRepositoty.find(id);
    }

    @Override
    public List<Starship> list() {
       return starshipRepositoty.list();
    }
    
}
