package model;

public class Equipment {
    private String equipmentId;
    private String description;
    private String labLocation;
    private String status;

    public Equipment(String equipmentId, String description, String labLocation) {
        this.equipmentId = equipmentId;
        this.description = description;
        this.labLocation = labLocation;
        this.status = "AVAILABLE";
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public String getDescription() {
        return description;
    }

    public String getLabLocation() {
        return labLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
