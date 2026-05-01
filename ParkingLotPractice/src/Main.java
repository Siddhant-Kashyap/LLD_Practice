import Driver.ParkingLot;
import Entity.*;
import Enums.VehicleType;
import Services.PaymentService;
import Strategy.DynamicPayment;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<ParkingSpot> floor1Spots = new ArrayList<>();
        floor1Spots.add(new ParkingSpot(1, VehicleType.BIKE));
        floor1Spots.add(new ParkingSpot(2, VehicleType.BIKE));
        floor1Spots.add(new ParkingSpot(3, VehicleType.CAR));
        floor1Spots.add(new ParkingSpot(4, VehicleType.CAR));
        floor1Spots.add(new ParkingSpot(5, VehicleType.BUS));

        List<ParkingFloor> floors = List.of(new ParkingFloor(1, floor1Spots));

        ParkingLot lot = ParkingLot.init(floors);
        PaymentService paymentService = new PaymentService(new DynamicPayment());

        EntryGate entry = new EntryGate(1, lot);
        ExitGate exit = new ExitGate(1, lot, paymentService);

        System.out.println("=== ENTERING ===");
        Ticket t1 = entry.entry(new Car("KA-01-1234"));
        Ticket t2 = entry.entry(new Bike("KA-02-5678"));
        Ticket t3 = entry.entry(new Bus("KA-03-9999"));

        System.out.println("Active: " + lot.getActiveCount());

        System.out.println("\n=== EXITING ===");
        exit.processExit(t1.getTicketId());
        exit.processExit(t2.getTicketId());

        System.out.println("Active: " + lot.getActiveCount());

        System.out.println("\n=== RE-PARK ===");
        Ticket t4 = entry.entry(new Car("KA-05-2222"));
        System.out.println("Active: " + lot.getActiveCount());
    }
}