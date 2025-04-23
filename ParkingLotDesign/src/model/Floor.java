package model;

import java.util.List;

public class Floor {

    private String id;
    private List<ParkingSpot> spotList;

    public Floor(String id, List<ParkingSpot> spotList) {
        this.id = id;
        this.spotList = spotList;
    }

    public List<ParkingSpot> getAvailableSpots() {
        return spotList.stream().filter(spots -> !spots.isOccupied()).toList();
    }

}
