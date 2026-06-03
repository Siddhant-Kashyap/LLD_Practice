package Entity;

public class ParkingSpot {
    private int spotId;
    private Vehicle vehicle;
    private boolean isAvailable;
    private VehicleType spotType;

    public ParkingSpot(int spotId,VehicleType spotType) {
        this.spotId = spotId;
        this.vehicle = null;
        this.isAvailable = true;
        this.spotType = spotType;
    }
    public synchronized void unpark(){
        //unpark
        setAvailable(true);
        setVehicle(null);

    }
    public synchronized void  park(Vehicle vehicle){
        setVehicle(vehicle);
        setAvailable(false);
    }



    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public VehicleType getSpotType() {
        return spotType;
    }

    public void setSpotType(VehicleType spotType) {
        this.spotType = spotType;
    }
}
