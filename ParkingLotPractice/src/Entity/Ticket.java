package Entity;

import java.time.LocalDateTime;

public class Ticket {
    private final String ticketId;
    private final LocalDateTime entryTime;
    private final ParkingSpot spot;
    private final Vehicle vehicle;

    public Ticket(String ticketId, LocalDateTime entryTime, ParkingSpot spot, Vehicle vehicle) {
        this.ticketId = ticketId;
        this.entryTime = entryTime;
        this.spot = spot;
        this.vehicle = vehicle;
    }

    public String getTicketId() {
        return ticketId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}