package com.example.service;

import java.util.List;

import com.example.model.Enrollment;

public interface IEnrollmentService {
    
 List<Enrollment> list();

    Enrollment save(Enrollment enrollment);

    Enrollment find(int id);

}
