package com.example.service;

import java.util.List;

import com.example.model.Course;

public interface  ICourseService {
       List<Course> list();

    Course save(Course course);

    Course find(int id);
}
