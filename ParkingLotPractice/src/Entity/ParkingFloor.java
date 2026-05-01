package Entity;

import Enums.VehicleType;

import java.util.List;

public class ParkingFloor {
    private int floorNo;
    private List<ParkingSpot> spots;

    public ParkingFloor(int floorNo, List<ParkingSpot> spots){
        this.floorNo =floorNo;
        this.spots = spots;
    }

    public ParkingSpot findEmptySpot(VehicleType type){
        for(ParkingSpot spot:spots){
            if(spot.isAvailable() && spot.getSpotType() == type){
                return spot;
            }
        }
        return null;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle){
        ParkingSpot spot = findEmptySpot(vehicle.getVehicleType());
        spot.park(vehicle);
        return spot;
    }


    public void unparkVehicle(ParkingSpot spot){
        Vehicle vehicle = spot.getVehicle();
        if(vehicle!=null){
            spot.unpark();
        }

    }






    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public void setSpots(List<ParkingSpot> spots) {
        this.spots = spots;
    }
}
