package Strategy;

import Entity.Ticket;

public class UpiPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Paying using UPI: "+ amount);
    }
}
