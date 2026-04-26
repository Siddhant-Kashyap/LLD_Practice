public abstract class Vehicle {
    public String plateNo;
    public VehicleType vehicleType;

    public Vehicle(String plateNo,VehicleType vehicleType){
        this.plateNo=plateNo;
        this.vehicleType=vehicleType;
    }

    public String getPlateNo() {
        return this.plateNo;
    }
    public VehicleType getVehicleType(){
        return this.vehicleType;
    }
}
