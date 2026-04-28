package Strategy;

import Entity.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyPayment implements PaymentStrategy
{
    @Override
    public double calculateFee(Ticket ticket) {
        long hours = Duration.between(ticket.entryTime, LocalDateTime.now()).toHours() + 3;
        switch (ticket.vehicle.vehicleType) {
            case BIKE: return hours * 10;
            case CAR:  return hours * 20;
            case BUS:  return hours * 50;
            default:   return 0;
        }
    }
}
