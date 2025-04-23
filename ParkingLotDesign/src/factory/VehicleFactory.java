package factory;

import model.Bike;
import model.Car;
import model.Truck;
import model.Vehicle;
import model.enums.VehicleType;

public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType vehicleType, String licensePlate) {
        return switch (vehicleType) {
            case CAR -> new Car(licensePlate);
            case BIKE -> new Bike(licensePlate);
            case TRUCK -> new Truck(licensePlate);
        };

    }
}
