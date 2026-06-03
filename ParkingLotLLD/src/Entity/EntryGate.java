package Entity;

import Service.ParkingLot;

import java.time.LocalDateTime;
import java.util.UUID;

public class EntryGate {
    private int gateNo ;
    private ParkingLot lot;

    public EntryGate(int gateNo,ParkingLot lot) {
        this.gateNo = gateNo;
        this.lot =lot;
    }
    public Ticket entry(Vehicle vehicle){
        LocalDateTime entryTime = LocalDateTime.now();
        String ticketId = "TIC"+UUID.randomUUID();
        ParkingSpot spot =lot.findSpotAndPark(vehicle);
        return new Ticket(entryTime,spot,vehicle,ticketId);
    }
}
