package Entity;

import Services.ParkingLot;
import Services.PaymentService;

public class ExitGate {
    public  String gateNo;
    public ParkingLot  parkingLot;
    public PaymentService paymentService;

    public ExitGate(String gateNo, ParkingLot lot, PaymentService paymentService) {
        this.gateNo=gateNo;
        this.parkingLot = lot;
        this.paymentService =paymentService;
    }
    public double exit(Ticket ticket){
        double fee = paymentService.processPayment(ticket);
        parkingLot.unparkVehicle(ticket);
        return fee;
    }

}
