package strategy;

import model.ParkingSpot;
import model.Vehicle;

import java.util.List;

public interface ParkingStrategy {
    ParkingSpot findSpot(List<ParkingSpot> spots, Vehicle vehicle);
}
