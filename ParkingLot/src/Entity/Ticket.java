package Entity;

import java.time.LocalDateTime;

public class Ticket {
    public  String ticketNo;
    public Vehicle vehicle;
    public ParkingSpot parkingSpot;
    public LocalDateTime entryTime;

    public Ticket(String ticketNo, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.ticketNo = ticketNo;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = LocalDateTime.now();
    }
}
