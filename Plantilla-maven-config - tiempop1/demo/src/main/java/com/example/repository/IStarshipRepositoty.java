package com.example.repository;

import java.util.List;

import com.example.model.Starship;

public interface  IStarshipRepositoty {

    void init();

    Starship save(Starship starship);

    Starship find(int id);

    List<Starship> list();
    
}
