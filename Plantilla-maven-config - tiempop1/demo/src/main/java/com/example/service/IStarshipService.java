package com.example.service;

import java.util.List;

import com.example.model.Starship;

public interface IStarshipService {
    Starship save(Starship starship);

    Starship find(int id);

    List<Starship> list();
}
