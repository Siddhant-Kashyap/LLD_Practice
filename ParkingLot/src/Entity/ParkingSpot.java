package Entity;

import Enums.SlotType;

public class ParkingSpot {
    private String slotId;
    private SlotType slotType;
    private Vehicle vehicle;

    public ParkingSpot(String slotId, SlotType slotType) {
        this.slotId = slotId;
        this.slotType = slotType;
        this.vehicle = null;
    }

    public boolean canFit(Vehicle vehicle){
        if(this.vehicle != null ) return false;
        return vehicle.getVehicleType().name().equals(slotType.name());
    }

    public synchronized boolean park(Vehicle vehicle){
        if(!canFit(vehicle)) return false;
        this.vehicle = vehicle;
        return true;
    }

    public synchronized boolean unpark(){
        if(this.vehicle == null) return false;
        this.vehicle = null;
        return true;
    }


    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public void setSlotType(SlotType slotType) {
        this.slotType = slotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
