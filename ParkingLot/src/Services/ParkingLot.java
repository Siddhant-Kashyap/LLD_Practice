package Services;

import Entity.ParkingFloor;
import Entity.ParkingSpot;
import Entity.Ticket;
import Entity.Vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    public List<ParkingFloor> floors;
    public Map<String, ParkingSpot> vehiclemap; //O(1)
    public Map<String, Ticket> activeTicket; // o(1)

    public ParkingLot(List<ParkingFloor> floors){
        this.floors = floors;
        this.vehiclemap = new HashMap<>();
        this.activeTicket = new HashMap<>();
    }

    public ParkingSpot parkVehicle(Vehicle vehicle) throws Exception{
        for(ParkingFloor floor: floors){
            ParkingSpot spot = floor.parkVehicle(vehicle);
            if(spot!=null){
                vehiclemap.put((vehicle.plateNo),spot);
                return spot;
            }
        }
        throw new Exception("Parking is already full");
    }
    public void unparkVehicle(Ticket ticket){
        ParkingSpot spot = ticket.parkingSpot;
        spot.unpark();
        activeTicket.remove(ticket.ticketNo);
        vehiclemap.remove(ticket.vehicle.plateNo);

    }
    public void addTicket(Ticket ticket){
        activeTicket.put(ticket.ticketNo,ticket);
    }

}
