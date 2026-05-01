package Services;

import Entity.Ticket;
import Strategy.IPaymentStategy;

public class PaymentService {
    private final Ticket ticket;
    private final IPaymentStategy paymentStategy;

    public PaymentService(Ticket ticket,IPaymentStategy paymentStategy){
        this.ticket =ticket;
        this.paymentStategy= paymentStategy;
    }

    public double amount(){
        return paymentStategy.calculatePayment(this.ticket);
    }
}
