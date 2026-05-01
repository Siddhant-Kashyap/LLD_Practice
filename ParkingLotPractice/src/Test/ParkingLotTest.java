package Test;

import Driver.ParkingLot;
import Entity.*;
import Enums.VehicleType;
import Services.PaymentService;
import Strategy.DynamicPayment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    private ParkingLot lot;
    private EntryGate entryGate;
    private ExitGate exitGate;

    @BeforeEach
    void setUp() {
        // Reset singleton to ensure isolation
        ParkingLot.reset();
        
        // Setup a small lot for testing
        List<ParkingSpot> spots = new ArrayList<>();
        spots.add(new ParkingSpot(1, VehicleType.CAR));
        spots.add(new ParkingSpot(2, VehicleType.BIKE));
        
        List<ParkingFloor> floors = new ArrayList<>();
        floors.add(new ParkingFloor(1, spots));

        lot = ParkingLot.init(floors);
        
        PaymentService paymentService = new PaymentService(new DynamicPayment());
        entryGate = new EntryGate(1, lot);
        exitGate = new ExitGate(1, lot, paymentService);
    }

    @Test
    void testSuccessfulParking() {
        Vehicle car = new Car("TEST-CAR");
        Ticket ticket = entryGate.entry(car);
        
        assertNotNull(ticket, "Ticket should not be null for available spot");
        assertEquals(1, ticket.getSpot().getSpotId(), "Car should take Spot 1");
        assertFalse(ticket.getSpot().isAvailable(), "Spot should be occupied");
    }

    @Test
    void testSpotTypeMatching() {
        Vehicle bike = new Bike("TEST-BIKE");
        Ticket ticket = entryGate.entry(bike);
        
        assertNotNull(ticket);
        assertEquals(VehicleType.BIKE, ticket.getSpot().getSpotType());
        assertEquals(2, ticket.getSpot().getSpotId(), "Bike should go to Spot 2");
    }

    @Test
    void testParkingFull() {
        // Fill the only car spot
        entryGate.entry(new Car("CAR-1"));
        
        // Try to park another car
        Vehicle car2 = new Car("CAR-2");
        Ticket ticket = entryGate.entry(car2);
        
        assertNull(ticket, "Ticket should be null when lot is full for that type");
    }

    @Test
    void testExitAndPayment() {
        Vehicle car = new Car("PAY-CAR");
        Ticket ticket = entryGate.entry(car);
        
        double amount = exitGate.processExit(ticket.getTicketId());
        
        assertTrue(amount >= 0, "Payment should be non-negative");
        assertTrue(ticket.getSpot().isAvailable(), "Spot should be free after exit");
        assertNull(lot.getTicket(ticket.getTicketId()), "Ticket should be removed from active tickets");
    }

    @Test
    void testConcurrentParking() throws InterruptedException {
        // This simulates two gates trying to park at the exact same time
        // Since we only have one car spot, only one should succeed.
        
        Thread t1 = new Thread(() -> entryGate.entry(new Car("CONC-1")));
        Thread t2 = new Thread(() -> entryGate.entry(new Car("CONC-2")));
        
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        
        // Check that only one car is parked and spot availability is consistent
        int activeTickets = lot.getActiveCount();
        assertTrue(activeTickets <= 1, "Concurrency issue: more cars parked than spots available");
    }
}
