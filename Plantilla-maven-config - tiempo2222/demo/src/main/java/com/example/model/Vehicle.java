package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private int id;
    private String name;
    private String RegistryCode;
    private String ClassType;
    private String Captain;
    private String CommissionDate;
    private String Status;
    private List<MechanicVisit> visits;

    public Vehicle(String Captain, String ClassType, String CommissionDate, String RegistryCode, String Status, int id, String name) {
        this.Captain = Captain;
        this.ClassType = ClassType;
        this.CommissionDate = CommissionDate;
        this.RegistryCode = RegistryCode;
        this.Status = Status;
        this.id = id;
        this.name = name;
        this.visits = new ArrayList<>();
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

    public List<MechanicVisit> getVisits() {
        return visits;
    }

    public void setVisits(List<MechanicVisit> visits) {
        this.visits = visits;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehicle{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", RegistryCode=").append(RegistryCode);
        sb.append(", ClassType=").append(ClassType);
        sb.append(", Captain=").append(Captain);
        sb.append(", CommissionDate=").append(CommissionDate);
        sb.append(", Status=").append(Status);
        sb.append(", visits=").append(visits);
        sb.append('}');
        return sb.toString();
    }
}
