package Entity;

import Services.ParkingLot;

import java.util.UUID;

public class EntryGate {
    public String gateNo;
    public ParkingLot parkingLot;

    public EntryGate(String gateNo,ParkingLot parkingLot){
        this.gateNo = gateNo;
        this.parkingLot = parkingLot;
    }
    public Ticket entry(Vehicle vehicle) throws Exception {
        ParkingSpot spot = parkingLot.parkVehicle(vehicle);
        String ticketNo = UUID.randomUUID().toString();
        return new Ticket(ticketNo,vehicle,spot);
    }
}
