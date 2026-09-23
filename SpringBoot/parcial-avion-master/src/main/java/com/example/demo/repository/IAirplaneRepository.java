package com.example.demo.repository;

import com.example.demo.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAirplaneRepository extends JpaRepository<Airplane, Long> {
}
