package com.example.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Starship;
import com.example.repository.IStarshipRepositoty;

public class StarshipRepositotyImpl implements IStarshipRepositoty {

 private List<Starship> starships = new ArrayList<>();
    private int countId=0;

   @Override
    public void init() {
//String Captain, String ClassType, String CommissionDate, String RegistryCode, String Status, int id, String name

starships.add(new Starship("fajardo","dwqqsq","dwad","popopopo","arads",countId++,"ojjoa"));
starships.add(new Starship("aponza","dwqqsq2","dwad2","popopopo","arads",countId++,"ojjoa"));
starships.add(new Starship("cubillo","dwqqsq3","dwad3","popopopo","arads",countId++,"ojjoa"));
    }

    @Override
    public Starship save(Starship starship) {

        if(starship == null){
            return  null;
        }else{

            starship.setId(countId++);
            starships.add(starship);

            return starship;
        }

    } 

    @Override
    public Starship find(int id) {

        for(Starship s: starships){
            if (s.getId()==id) {

                return s;
                
            }
        }   

        return null;

    }

    @Override
    public List<Starship> list() {
return starships;
    }


}
