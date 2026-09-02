package com.example.service.impl;

import java.util.List;

import com.example.model.Course;
import com.example.repository.ICourseRepository;
import com.example.service.ICourseService;

public class CourseServiceImpl implements  ICourseService{

    private ICourseRepository courseRepository;


    public CourseServiceImpl (ICourseRepository courseRepository){

        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> list() {
return courseRepository.list();    }

    @Override
    public Course save(Course course) {
return courseRepository.save(course);    }

    @Override
    public Course find(int id) {

        return courseRepository.find(id);
    }

    
    
}
