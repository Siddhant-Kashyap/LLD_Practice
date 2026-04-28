package Services;

import Entity.Ticket;
import Strategy.PaymentStrategy;

public class PaymentService  {
    public PaymentStrategy paymentStrategy;

    public PaymentService(PaymentStrategy paymentStrategy){
        this.paymentStrategy=paymentStrategy;
    }
    public double processPayment(Ticket ticket){
        return paymentStrategy.calculateFee(ticket);
    }
}
