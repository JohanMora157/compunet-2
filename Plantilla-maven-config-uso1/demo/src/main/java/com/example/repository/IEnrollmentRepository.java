package com.example.repository;

import java.util.List;

import com.example.model.Enrollment;

public interface  IEnrollmentRepository {
    
    void init();

    List<Enrollment> list();

    Enrollment save(Enrollment enrollment);

    Enrollment find(int id);

}
