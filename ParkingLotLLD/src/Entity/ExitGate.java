package Entity;

import PaymentService.PaymentSystem;
import Service.ParkingLot;

public class ExitGate {
    private int exitGateId;
    private PaymentSystem paymentSystem;

    public ExitGate(int exitGateId,PaymentSystem paymentSystem) {
        this.exitGateId = exitGateId;
        this.paymentSystem = paymentSystem;
    }

    public void processExit(Ticket ticket){
        ParkingSpot spot = ticket.getSpot();
        spot.unpark();
        Vehicle vehicle = ticket.getVehicle();
        double payment = paymentSystem.processPayment(ticket);
        System.out.println("=================================");
        System.out.println("Your Final Payment is :"+ payment);
        System.out.println("=================================");
    }

}
