package model;

import model.enums.Spot;

public class ParkingSpot {
    public String getId() {
        return id;
    }

    private final String id;
    private final Spot type;

    public boolean isOccupied() {
        return isOccupied;
    }

    private boolean isOccupied;
    private Vehicle currentVehicle;

    public ParkingSpot(String id, Spot type) {
        this.id = id;
        this.type = type;
    }

    public boolean canFit(Vehicle vehicle) {
        return !isOccupied;
    }

    public void park(Vehicle vehicle) {
        this.currentVehicle = vehicle;
        this.isOccupied = true;
    }

    public void unpark() {
        this.currentVehicle = null;
        this.isOccupied = false;
    }
}
