package com.example.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Course;
import com.example.repository.ICourseRepository;

public class CourseRepositoryImpl implements  ICourseRepository{

    private List<Course> courses = new ArrayList<>();
    private int idCount = 1;

    @Override
    public void init() {

        courses.add(new Course(true, "a001", idCount++, 5, "Compunet"));
        courses.add(new Course(true, "a002", idCount++, 10, "SID2"));
        courses.add(new Course(true, "a003", idCount++, 5, "Arqui"));

    }

    @Override
    public List<Course> list() {
        return courses;
    }

    @Override
    public Course save(Course course) {
        if(course == null){

            return null;
        }else{

            courses.add(course);
            course.setId(idCount++);

            return course;
        }
    }

    @Override
    public Course find(int id) {

        for(Course c: courses){
            if(c.getId() == id){
                return c;
                }
        }

        return null;
    }


    
    
}
