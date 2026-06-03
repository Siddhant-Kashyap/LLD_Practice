package Service;

import Entity.ParkingFloor;
import Entity.ParkingSpot;
import Entity.Vehicle;

import java.util.List;

public class ParkingLot {
    private int lotId;
    private List<ParkingFloor> floors;

    public ParkingLot(int lotId, List<ParkingFloor> floors) {
        this.lotId = lotId;
        this.floors = floors;
    }


    public ParkingSpot findSpotAndPark(Vehicle vehicle){
        ParkingSpot spot = null;
        for(ParkingFloor floor :floors){
             spot = floor.findSpot(vehicle.getVehicleType());
             if(spot!= null) break;
        }
        if(spot!=null){
            spot.park(vehicle);
        }else{
            System.out.println("Parking spot not found");
        }
        return  spot;
    }



    public int getLotId() {
        return lotId;
    }

    public void setLotId(int lotId) {
        this.lotId = lotId;
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
    }
}
