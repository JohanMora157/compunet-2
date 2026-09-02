package com.example.service.impl;

import java.util.List;

import com.example.model.Enrollment;
import com.example.repository.ICourseRepository;
import com.example.repository.IEnrollmentRepository;
import com.example.service.IEnrollmentService;

public class EnrollmentServiceImpl implements IEnrollmentService{

    private IEnrollmentRepository enrollmentRepository;
    private ICourseRepository courseRepository;

    public EnrollmentServiceImpl(IEnrollmentRepository enrollmentRepository,ICourseRepository courseRepository){
this.enrollmentRepository = enrollmentRepository;
this.courseRepository = courseRepository;

    }


    @Override
    public List<Enrollment> list() {
return enrollmentRepository.list();    }

    @Override
    public Enrollment save(Enrollment enrollment) {

        if(courseRepository.find(enrollment.getCourseId())==null){

            throw new IllegalArgumentException("el curso no existe");

        }else if (courseRepository.find(enrollment.getCourseId()).isActive()==false){ 
            
throw new IllegalArgumentException("el curso esta inactivo");


        }else{

return enrollmentRepository.save(enrollment);  
        }



  }

    @Override
    public Enrollment find(int id) {
    return  enrollmentRepository.find(id);
    }
    
}
