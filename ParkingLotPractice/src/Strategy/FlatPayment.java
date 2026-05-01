package Strategy;

import Entity.Ticket;

public class FlatPayment implements IPaymentStategy{
    @Override
    public double calculatePayment(Ticket ticket) {
        return 5000.00;
    }
}
