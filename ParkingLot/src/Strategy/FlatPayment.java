package Strategy;

import Entity.Ticket;

public class FlatPayment implements PaymentStrategy{
    @Override
    public double calculateFee(Ticket ticket) {
        return 5000.00;
    }
}
