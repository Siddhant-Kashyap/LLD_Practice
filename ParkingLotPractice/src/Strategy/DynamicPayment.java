package Strategy;

import Entity.Ticket;
import Enums.VehicleType;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;

public class DynamicPayment implements IPaymentStrategy {

    private final Map<VehicleType, Double> hourlyRates;

    public DynamicPayment(Map<VehicleType, Double> hourlyRates) {
        this.hourlyRates = hourlyRates;
    }

    public DynamicPayment() {
        this.hourlyRates = Map.of(
                VehicleType.BIKE, 10.0,
                VehicleType.CAR, 20.0,
                VehicleType.BUS, 50.0
        );
    }

    @Override
    public double calculatePayment(Ticket ticket) {
        long hours = Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toHours();
        if (hours < 1) hours = 1;

        double rate = hourlyRates.getOrDefault(ticket.getVehicle().getVehicleType(), 20.0);
        return hours * rate;
    }
}
