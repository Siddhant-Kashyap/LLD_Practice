package Entity;

import Driver.ParkingLot;

import java.time.LocalDateTime;
import java.util.UUID;

public class Entrygate {
    private int gateId;
    private ParkingLot lot;

    public  Entrygate(int gateId, ParkingLot lot){
        this.gateId = gateId;
        this.lot = lot;
    }

    public Ticket entry(Vehicle vehicle){
        ParkingSpot spot =lot.park(vehicle);
        if(spot!=null){
           Ticket ticket = new Ticket(UUID.randomUUID().toString(),LocalDateTime.now(),spot,vehicle);
           lot.setActiveTicket(ticket.getTicketID(),vehicle);
           return ticket;
        }
        return null;
    }
}
