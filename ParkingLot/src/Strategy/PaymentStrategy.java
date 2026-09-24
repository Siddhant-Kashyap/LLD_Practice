package Strategy;


import Entity.Ticket;

public interface PaymentStrategy {
    void pay(double amount);
}
