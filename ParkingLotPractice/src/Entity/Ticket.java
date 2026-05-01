package Entity;

import java.time.LocalDateTime;

public class Ticket {
    private String ticketID;
    private LocalDateTime entryTime;
    private ParkingSpot spot;
    private Vehicle vehicle;

    public Ticket(String ticketID, LocalDateTime entryTime, ParkingSpot spot, Vehicle vehicle){
        this.ticketID = ticketID;
        this.entryTime= entryTime;
        this.spot = spot;
        this.vehicle = vehicle;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public void setSpot(ParkingSpot spot) {
        this.spot = spot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
