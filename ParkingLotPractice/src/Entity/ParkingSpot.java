package Entity;

import Enums.VehicleType;

public class ParkingSpot {
    private final int spotId;
    private final VehicleType spotType;
    private volatile boolean available = true;
    private Vehicle vehicle;

    public ParkingSpot(int spotId, VehicleType spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
    }

    public synchronized boolean park(Vehicle vehicle) {
        if (!available) return false;
        this.vehicle = vehicle;
        this.available = false;
        return true;
    }

    public synchronized void unpark() {
        this.vehicle = null;
        this.available = true;
    }

    public int getSpotId() { return spotId; }
    public VehicleType getSpotType() { return spotType; }
    public boolean isAvailable() { return available; }
    public Vehicle getVehicle() { return vehicle; }
}