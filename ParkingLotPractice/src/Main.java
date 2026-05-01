import Driver.ParkingLot;
import Entity.*;
import Enums.VehicleType;
import Services.PaymentService;
import Strategy.DynamicPayment;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Setup Parking Lot with 1 Floor and 3 Spots
        List<ParkingSpot> spots = new ArrayList<>();
        spots.add(new ParkingSpot(1, VehicleType.CAR));
        spots.add(new ParkingSpot(2, VehicleType.BIKE));
        spots.add(new ParkingSpot(3, VehicleType.CAR));

        List<ParkingFloor> floors = new ArrayList<>();
        floors.add(new ParkingFloor(1, spots));

        ParkingLot lot = ParkingLot.init(floors);

        // 2. Setup Services and Gates
        PaymentService paymentService = new PaymentService(new DynamicPayment());
        EntryGate entryGate = new EntryGate(1, lot);
        ExitGate exitGate = new ExitGate(1, lot, paymentService);

        System.out.println("--- Starting Parking Lot Test ---");

        // 3. Test Case 1: Successful Parking
        Vehicle car1 = new Car("KA-01-HH-1234");
        Ticket ticket1 = entryGate.entry(car1);
        assert ticket1 != null : "Car 1 should have parked";
        System.out.println("Test 1 Passed: Car 1 parked.");

        // 4. Test Case 2: Spot matching (Bike shouldn't go to Car spot if Bike spot is available)
        Vehicle bike1 = new Bike("KA-05-MM-5678");
        Ticket ticket2 = entryGate.entry(bike1);
        assert ticket2.getSpot().getSpotId() == 2 : "Bike should be at Spot 2";
        System.out.println("Test 2 Passed: Bike parked in correct spot type.");

        // 5. Test Case 3: Parking full for a specific type
        Vehicle car2 = new Car("KA-01-AA-9999");
        entryGate.entry(car2); // Occupies the second car spot (Spot 3)
        
        Vehicle car3 = new Car("KA-01-FULL");
        Ticket ticketFull = entryGate.entry(car3);
        assert ticketFull == null : "Car 3 should not find a spot";
        System.out.println("Test 3 Passed: Successfully handled 'Lot Full' scenario.");

        // 6. Test Case 4: Exit and Payment
        try {
            Thread.sleep(1000); // Simulate some time passing for payment
            double amount = exitGate.processExit(ticket1.getTicketId());
            assert amount > 0 : "Payment should be calculated";
            
            // 7. Test Case 5: Verify spot is freed after exit
            Ticket ticket4 = entryGate.entry(car3); // Now car3 should find the spot car1 left
            assert ticket4 != null : "Spot should be available after car1 exited";
            assert ticket4.getSpot().getSpotId() == 1 : "Car 3 should take Spot 1";
            System.out.println("Test 4 & 5 Passed: Exit, Payment, and Spot Re-allocation working.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("--- All Unit Tests Passed ---");
    }
}
