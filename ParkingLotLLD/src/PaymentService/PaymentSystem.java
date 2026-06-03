package PaymentService;

import Entity.Ticket;

public class PaymentSystem {
    private IPayment payment;
    public PaymentSystem(IPayment payment){
        this.payment=payment;
    }
    public double processPayment(Ticket ticket){
        return payment.calculate(ticket);
    }
}
