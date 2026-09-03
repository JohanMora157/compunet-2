package com.example.model;

public class MechanicVisit {
    private int id;
    private String LogCode;
    private String Title;
    private String Description;
    private String StarDate;
    private String Sector;
    private int ThreatLevel;
    private int VehicleId;

    public MechanicVisit(String Description, String LogCode, String Sector, String StarDate, int VehicleId, int ThreatLevel, String Title, int id) {
        this.Description = Description;
        this.LogCode = LogCode;
        this.Sector = Sector;
        this.StarDate = StarDate;
        this.VehicleId = VehicleId;
        this.ThreatLevel = ThreatLevel;
        this.Title = Title;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogCode() {
        return LogCode;
    }

    public void setLogCode(String LogCode) {
        this.LogCode = LogCode;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getStarDate() {
        return StarDate;
    }

    public void setStarDate(String StarDate) {
        this.StarDate = StarDate;
    }

    public String getSector() {
        return Sector;
    }

    public void setSector(String Sector) {
        this.Sector = Sector;
    }

    public int getThreatLevel() {
        return ThreatLevel;
    }

    public void setThreatLevel(int ThreatLevel) {
        this.ThreatLevel = ThreatLevel;
    }

    public int getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(int VehicleId) {
        this.VehicleId = VehicleId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MechanicVisit{");
        sb.append("id=").append(id);
        sb.append(", LogCode=").append(LogCode);
        sb.append(", Title=").append(Title);
        sb.append(", Description=").append(Description);
        sb.append(", StarDate=").append(StarDate);
        sb.append(", Sector=").append(Sector);
        sb.append(", ThreatLevel=").append(ThreatLevel);
        sb.append(", VehicleId=").append(VehicleId);
        sb.append('}');
        return sb.toString();
    }
}
