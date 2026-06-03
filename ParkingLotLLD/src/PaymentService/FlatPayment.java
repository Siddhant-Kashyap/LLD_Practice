package PaymentService;

import Entity.Ticket;

import java.time.LocalDateTime;

public class FlatPayment implements IPayment{

    @Override
    public double calculate(Ticket ticket) {
        return 10;
    }
}
