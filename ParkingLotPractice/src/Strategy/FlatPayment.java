package Strategy;

import Entity.Ticket;

public class FlatPayment implements IPaymentStrategy {

    private final double flatRate;

    public FlatPayment(double flatRate) {
        this.flatRate = flatRate;
    }

    @Override
    public double calculatePayment(Ticket ticket) {
        return flatRate;
    }
}