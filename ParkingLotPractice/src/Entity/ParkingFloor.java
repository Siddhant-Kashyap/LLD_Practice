package Entity;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ParkingFloor {
    private final int floorNo;
    private final List<ParkingSpot> spots;
    private final ReentrantLock lock = new ReentrantLock();

    public ParkingFloor(int floorNo, List<ParkingSpot> spots) {
        this.floorNo = floorNo;
        this.spots = spots;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        lock.lock();
        try {
            for (ParkingSpot spot : spots) {
                if (spot.isAvailable() && spot.getSpotType() == vehicle.getVehicleType()) {
                    if (spot.park(vehicle)) return spot;
                }
            }
            return null;
        } finally {
            lock.unlock();
        }
    }

    public void unparkVehicle(ParkingSpot spot) {
        spot.unpark();
    }

    public int getFloorNo() { return floorNo; }
    public List<ParkingSpot> getSpots() { return spots; }
}