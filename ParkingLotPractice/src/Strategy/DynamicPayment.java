package Strategy;

import Entity.Ticket;
import Entity.Vehicle;

public class DynamicPayment implements IPaymentStategy
{
    @Override
    public double calculatePayment(Ticket ticket) {
        Vehicle vehicle = ticket.getVehicle();
        switch (vehicle.getVehicleType()){
            case CAR -> {
                return 1000.00;
            }
            case BUS -> {
                return 500000.00;
            }
            case BIKE -> {
                return 500.00;
            }
            default -> {
                return 0.00;
            }
        }
    }
}
