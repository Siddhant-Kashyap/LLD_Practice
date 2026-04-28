import Entity.*;
import Services.ParkingLot;
import Services.PaymentService;
import Strategy.FlatPayment;
import Strategy.HourlyPayment;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        List<ParkingSpot> spots = Arrays.asList(
                new ParkingSpot("1", VehicleType.CAR),
                new ParkingSpot("2", VehicleType.CAR),
                new ParkingSpot("3", VehicleType.BIKE),
                new ParkingSpot("4", VehicleType.BUS)
        );
        ParkingFloor floor1 = new ParkingFloor(1,spots);
        ParkingLot lot = new ParkingLot(List.of(floor1));

        EntryGate entryGate = new EntryGate("E1",lot);

        PaymentService paymentService = new PaymentService(new FlatPayment());
        ExitGate exit = new ExitGate("X1",lot,paymentService);

        Vehicle car = new Car("KA-01-26666",VehicleType.CAR);
        Vehicle car2 = new Car("KA-01-26667",VehicleType.CAR);

        Ticket ticket = entryGate.entry(car);
        Ticket t1 = entryGate.entry(car2);
        System.out.println("PARKED --->"+car.plateNo+"at Spot" + ticket.parkingSpot);
        System.out.println("PARKED --->"+car2.plateNo+"at Spot" + ticket.parkingSpot);

        Thread.sleep(3000);

        double fee = exit.exit(ticket);
        double fee2 = exit.exit(t1);
        System.out.println("Fee Was "+ fee);
        System.out.println("Fee"+ fee2);



     }
}