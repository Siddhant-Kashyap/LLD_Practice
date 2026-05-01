package Entity;

import Enums.VehicleType;

public abstract class Vehicle {
    private final String plateNo;
    private final VehicleType vehicleType;

    protected Vehicle(String plateNo, VehicleType vehicleType) {
        this.plateNo = plateNo;
        this.vehicleType = vehicleType;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}