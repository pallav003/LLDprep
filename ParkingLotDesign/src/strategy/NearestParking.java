package strategy;

import model.ParkingSpot;
import model.Vehicle;

import java.util.List;

public class NearestParking implements ParkingStrategy {
    @Override
    public ParkingSpot findSpot(List<ParkingSpot> spots, Vehicle vehicle) {
        for (ParkingSpot parkingSpot : spots) {
            if (!parkingSpot.isOccupied() && parkingSpot.canFit(vehicle)) {
                return parkingSpot;
            }
        }
        return null;
    }
}
