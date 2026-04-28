package Entity;

import java.util.List;

public class ParkingFloor {
    public int floorId;
    public List<ParkingSpot> parkingSpots;
    public ParkingFloor(int floorId , List<ParkingSpot> parkingSpots){
        this.floorId = floorId;
        this.parkingSpots = parkingSpots;
    }
    public ParkingSpot findAvailableParking(VehicleType vehicleType){
        for(ParkingSpot spot:parkingSpots){
            if(spot.spotType ==vehicleType && spot.isAvailable){
                return spot;
            }
        }
        return null;
    }
    public ParkingSpot parkVehicle(Vehicle vehicle) throws Exception {
        ParkingSpot spot = findAvailableParking(vehicle.vehicleType);
        if(spot!=null){
            spot.park(vehicle);
        }
        return spot;
    }
    public  void  unparkVehicle(ParkingSpot spot) throws Exception {
        if(spot.isAvailable){
            throw  new Exception("Spot is already available");
        }
        spot.unpark();

    }
}
