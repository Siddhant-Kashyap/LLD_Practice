package Entity;

public class ParkingSpot {
    public String spotId;
    public VehicleType spotType;
    public boolean isAvailable;
    public Vehicle vehicle;

    public ParkingSpot(String spotId, VehicleType spotType){
        this.spotId = spotId;
        this.spotType = spotType;
        this.isAvailable = true;
    }
    public void park(Vehicle vehicle) throws Exception {
        if(vehicle.vehicleType != this.spotType){
            throw new Exception("Spot does not match vehicle type");
        }
        if(!this.isAvailable){
            throw  new Exception("Spot is not available");
        }
        this.vehicle= vehicle;
        this.isAvailable = false;
    }
    public void unpark(){
        this.vehicle = null;
        this.isAvailable = true;
    }
}
