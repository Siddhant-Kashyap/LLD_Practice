package Entity;

import java.util.List;

public class ParkingFloor {
    private String floorId;
    private List<ParkingSpot> spots ;

    public ParkingFloor(String floorId, List<ParkingSpot> spots) {
        this.floorId = floorId;
        this.spots = spots;
    }

    public ParkingSpot findFreeSpot(Vehicle vehicle){
        for(ParkingSpot s:spots){
            if(s.canFit(vehicle)){
                return  s;
            }
        }
        return null;
    }



    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public void setSpots(List<ParkingSpot> spots) {
        this.spots = spots;
    }
}
