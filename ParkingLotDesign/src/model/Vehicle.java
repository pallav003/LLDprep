package model;

import model.enums.VehicleType;

public abstract class Vehicle {
    private final VehicleType type;
    private String licensePlate;

    protected Vehicle(String licensePlate, VehicleType type) {
        this.type = type;
        this.licensePlate = licensePlate;
    }

    public VehicleType getType() {
        return type;
    }
}
