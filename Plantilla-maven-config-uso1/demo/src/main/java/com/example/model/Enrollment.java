package com.example.model;

public class Enrollment {
    
private int id;
private String studentName;
private String studentCode;
private int courseId; 

    public Enrollment(int id, String studentCode, String studentName,int courseId) {
        this.courseId = courseId;
        this.id = id;
        this.studentCode = studentCode;
        this.studentName = studentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public int getCourseId() {
        return courseId;
    }

    public Enrollment setCourseId(int courseId) {
        this.courseId = courseId;
        return this;
    }



}


