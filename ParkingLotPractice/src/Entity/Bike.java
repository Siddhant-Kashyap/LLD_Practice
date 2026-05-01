package Entity;

import Enums.VehicleType;

public class Bike extends Vehicle {
    public Bike(String plateNo) {
        super(plateNo, VehicleType.BIKE);
    }
}
