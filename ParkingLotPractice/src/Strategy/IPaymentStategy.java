package Strategy;

import Entity.Ticket;

public interface IPaymentStategy {
    double calculatePayment(Ticket ticket);
}
