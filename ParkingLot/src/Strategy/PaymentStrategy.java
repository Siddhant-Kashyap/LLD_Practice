package Strategy;

import Entity.Ticket;

public interface PaymentStrategy {
    double calculateFee(Ticket ticket);
}
