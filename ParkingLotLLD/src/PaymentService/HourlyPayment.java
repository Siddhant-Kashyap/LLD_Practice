package PaymentService;

import Entity.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyPayment implements IPayment{

    @Override
    public double calculate(Ticket ticket) {
      LocalDateTime entryTime = ticket.getEntryTime();
      LocalDateTime exitTime = LocalDateTime.now();
      long hours = Duration.between(entryTime, exitTime).toHours();
        return hours * 20.0;
    }
}
