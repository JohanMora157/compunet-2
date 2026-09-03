package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Starship {
private int id;
private String name;
private String RegistryCode;
private String ClassType;
private String Captain;
private String CommissionDate;
private String Status;
private List<MissionLog> missions;

    public Starship(String Captain, String ClassType, String CommissionDate, String RegistryCode, String Status, int id, String name) {
        this.Captain = Captain;
        this.ClassType = ClassType;
        this.CommissionDate = CommissionDate;
        this.RegistryCode = RegistryCode;
        this.Status = Status;
        this.id = id;
        this.name = name;
        this.missions = new ArrayList<>();
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

    public String getRegistryCode() {
        return RegistryCode;
    }

    public void setRegistryCode(String registryCode) {
        RegistryCode = registryCode;
    }

    public String getClassType() {
        return ClassType;
    }

    public void setClassType(String classType) {
        ClassType = classType;
    }

    public String getCaptain() {
        return Captain;
    }

    public void setCaptain(String captain) {
        Captain = captain;
    }

    public String getCommissionDate() {
        return CommissionDate;
    }

    public void setCommissionDate(String commissionDate) {
        CommissionDate = commissionDate;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Starship{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", RegistryCode=").append(RegistryCode);
        sb.append(", ClassType=").append(ClassType);
        sb.append(", Captain=").append(Captain);
        sb.append(", CommissionDate=").append(CommissionDate);
        sb.append(", Status=").append(Status);
        sb.append(", missions=").append(missions);
        sb.append('}');
        return sb.toString();
    }



    
}


