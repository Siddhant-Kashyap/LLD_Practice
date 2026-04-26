public class ParkingSpot {
    public int spotId;
    public VehicleType vehicleType;
    public boolean isAvailable;
    public Vehicle vehicle;
    public ParkingSpot(int spotId,VehicleType type){
        this.spotId=spotId;
        this.vehicleType =type;
    }
    public void park(Vehicle vehicle) throws Exception {
        if(vehicle.vehicleType != this.vehicleType){
            throw new Exception("Spot does not match");
        }
        if(!this.isAvailable){
            throw new Exception("Spot is not Available");
        }
        this.isAvailable=false;
        this.vehicle=vehicle;
    }
    public void unpark(){
        this.vehicle=null;
        this.isAvailable=true;
    }
}
