package com.example.model;

public class Course {
    
private int id;
private String name;
private String code;
private int maxStudents;
private boolean active ;

    public Course(boolean active, String code, int id, int maxStudents, String name) {
        this.active = active;
        this.code = code;
        this.id = id;
        this.maxStudents = maxStudents;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


}

