package Entity;

import Enums.SpotType;
import Enums.VehicleType;

public class ParkingSpot {
    private int spotId;
    private boolean isAvailable;
    private Vehicle vehicle;
    private VehicleType spotType;

    public ParkingSpot(int spotId,VehicleType spotType){
        this.spotType=spotType;
        this.spotId=spotId;
    }

    public void park(Vehicle vehicle){
        this.vehicle =vehicle;
        this.isAvailable = false;
    }
    public void unpark(){
        this.vehicle = null;
        this.isAvailable = true;
    }




    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleType getSpotType() {
        return spotType;
    }

    public void setSpotType(VehicleType spotType) {
        this.spotType = spotType;
    }
}
