package Services;

import Entity.Ticket;
import Strategy.IPaymentStrategy;

public class PaymentService {
    private final IPaymentStrategy paymentStrategy;

    public PaymentService(IPaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public double calculateAmount(Ticket ticket) {
        return paymentStrategy.calculatePayment(ticket);
    }
}
