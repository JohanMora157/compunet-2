package com.example.repository;

import java.util.List;

import com.example.model.Course;

public interface  ICourseRepository {
    
    void init();

    List<Course> list();

    Course save(Course course);

    Course find(int id);
    

}
