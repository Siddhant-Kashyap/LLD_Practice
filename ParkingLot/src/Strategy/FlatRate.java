package Strategy;

import Entity.Ticket;
import Entity.Vehicle;

public class FlatRate implements RateChargingStrategy{
    @Override
    public double processRate(Ticket ticket) {
        return 200.0;
    }
}
