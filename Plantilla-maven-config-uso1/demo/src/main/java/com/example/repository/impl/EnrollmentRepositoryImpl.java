package com.example.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Enrollment;
import com.example.repository.IEnrollmentRepository;

public class EnrollmentRepositoryImpl implements IEnrollmentRepository {

    private List<Enrollment> enrollments = new ArrayList<>();
    private int idCount = 1;


    @Override
    public void init() {

        enrollments.add(new Enrollment(idCount++,"e001","juan",1));
        enrollments.add(new Enrollment(idCount++,"e002","pablo",2));
        enrollments.add(new Enrollment(idCount++,"e003","pipe",3));



    }

    @Override
    public List<Enrollment> list() {
return enrollments;    }

    @Override
    public Enrollment save(Enrollment enrollment) {
        if(enrollment == null){

            return null;
        }else{

                enrollments.add(enrollment);
                enrollment.setId(idCount++);

                return enrollment;
        }
    }
    @Override
    public Enrollment find(int id) {

        for(Enrollment e: enrollments){
            if(e.getId() == id){
                return e;
                }
        }

        return null;
    }


}
