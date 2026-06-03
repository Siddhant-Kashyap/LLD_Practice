package PaymentService;

import Entity.Ticket;

public interface IPayment {
    public double calculate(Ticket ticket);
}
