package Entity;

import Driver.ParkingLot;

import java.time.LocalDateTime;
import java.util.UUID;

public class EntryGate {
    private final int gateId;
    private final ParkingLot lot;

    public EntryGate(int gateId, ParkingLot lot) {
        this.gateId = gateId;
        this.lot = lot;
    }

    public Ticket entry(Vehicle vehicle) {
        ParkingSpot spot = lot.park(vehicle);
        if (spot == null) {
            System.out.println("Gate " + gateId + ": No spot available for " + vehicle.getVehicleType());
            return null;
        }

        Ticket ticket = new Ticket(UUID.randomUUID().toString(), LocalDateTime.now(), spot, vehicle);
        lot.addTicket(ticket);
        System.out.println("Gate " + gateId + ": Vehicle " + vehicle.getPlateNo()
                + " parked at Spot " + spot.getSpotId() + " | Ticket: " + ticket.getTicketId());
        return ticket;
    }

    public int getGateId() {
        return gateId;
    }
}