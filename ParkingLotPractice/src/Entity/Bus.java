package Entity;

import Enums.VehicleType;

public class Bus extends Vehicle {
    public Bus(String plateNo) {
        super(plateNo, VehicleType.BUS);
    }
}