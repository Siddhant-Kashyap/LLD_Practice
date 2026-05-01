package Entity;

import Driver.ParkingLot;
import Services.PaymentService;

public class ExitGate {
    private final int gateNo;
    private final ParkingLot lot;
    private final PaymentService paymentService;

    public ExitGate(int gateNo, ParkingLot lot, PaymentService paymentService) {
        this.gateNo = gateNo;
        this.lot = lot;
        this.paymentService = paymentService;
    }

    public double processExit(String ticketId) {
        Ticket ticket = lot.getTicket(ticketId);
        if (ticket == null) throw new IllegalArgumentException("Invalid ticket");

        double amount = paymentService.calculateAmount(ticket);
        lot.unpark(ticket);

        System.out.println("Gate " + gateNo + ": Vehicle " + ticket.getVehicle().getPlateNo()
                + " exited | Amount: " + amount);
        return amount;
    }
}