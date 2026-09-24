package Strategy;

import Entity.Ticket;

public interface RateChargingStrategy {
    double processRate(Ticket ticket);
}
