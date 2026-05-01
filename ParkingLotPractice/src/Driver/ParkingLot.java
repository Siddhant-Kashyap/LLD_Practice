package Driver;

import Entity.ParkingFloor;
import Entity.ParkingSpot;
import Entity.Vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private int lotId;
    private List<ParkingFloor> floors ;
    private Map<String,Vehicle> activeTicket;

    public ParkingLot(int lotId, List<ParkingFloor> floors) {
        this.lotId = lotId;
        this.floors = floors;
        this.activeTicket = new HashMap<>();
    }


    public ParkingSpot park(Vehicle vehicle){
        for(ParkingFloor floor : floors){
           return floor.parkVehicle(vehicle);
        }
        return null;
    }
    public void  unpark(ParkingSpot spot){
        spot.unpark();
    }


    public Map<String, Vehicle> getActiveTicket() {
        return activeTicket;
    }

    public void setActiveTicket(String ticketNo,Vehicle vehicle) {
        this.activeTicket.put(ticketNo,vehicle);
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
