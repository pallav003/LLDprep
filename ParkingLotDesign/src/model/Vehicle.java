package model;

import model.enums.VehicleType;

public abstract class Vehicle {
    private String licensePlate;
    private final VehicleType type;

    protected Vehicle(String licensePlate, VehicleType type) {
        this.type = type;
        this.licensePlate = licensePlate;
    }
    public VehicleType getType() {
        return type;
    }
}
