package Driver;

import Entity.ParkingFloor;
import Entity.ParkingSpot;
import Entity.Ticket;
import Entity.Vehicle;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {
    private static ParkingLot instance;

    private final List<ParkingFloor> floors;
    private final ConcurrentHashMap<String, Ticket> activeTickets = new ConcurrentHashMap<>();

    private ParkingLot(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public static synchronized ParkingLot init(List<ParkingFloor> floors) {
        if (instance == null) instance = new ParkingLot(floors);
        return instance;
    }

    public static ParkingLot getInstance() {
        return instance;
    }

    public ParkingSpot park(Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            ParkingSpot spot = floor.parkVehicle(vehicle);
            if (spot != null) return spot;
        }
        return null;
    }

    public void unpark(Ticket ticket) {
        ticket.getSpot().unpark();
        activeTickets.remove(ticket.getTicketId());
    }

    public void addTicket(Ticket ticket) {
        activeTickets.put(ticket.getTicketId(), ticket);
    }

    public Ticket getTicket(String ticketId) {
        return activeTickets.get(ticketId);
    }

    public int getActiveCount() {
        return activeTickets.size();
    }
}
