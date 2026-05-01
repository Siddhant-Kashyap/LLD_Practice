package Entity;

import Enums.VehicleType;

public abstract class Vehicle {
    private String plateNo;
    private VehicleType vehicleType;

    public Vehicle(String plateNo, VehicleType vehicleType) {
        this.plateNo = plateNo;
        this.vehicleType = vehicleType;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
