package model;

import strategy.ParkingStrategy;

import java.util.List;

public class ParkingLot {
    private List<Floor> floors;
    private ParkingStrategy strategy;

    public ParkingLot(List<Floor> floors, ParkingStrategy strategy) {
        this.strategy = strategy;
        this.floors = floors;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        for (Floor floor : floors) {
            ParkingSpot spot = strategy.findSpot(floor.getAvailableSpots(), vehicle);
            if (spot != null) {
                spot.park(vehicle);
                return spot;
            }
        }
        return null;
    }

    public void unparkVehicle(ParkingSpot spot) {
        spot.unpark();
    }
}
