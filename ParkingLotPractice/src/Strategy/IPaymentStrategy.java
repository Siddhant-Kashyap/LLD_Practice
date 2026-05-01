package Strategy;

import Entity.Ticket;

public interface IPaymentStrategy {
    double calculatePayment(Ticket ticket);
}