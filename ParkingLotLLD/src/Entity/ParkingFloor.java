package Entity;

import java.util.List;

public class ParkingFloor {
    private int floorNo;
    private List<ParkingSpot> spots;

    public ParkingFloor(int floorNo, List<ParkingSpot> spots) {
        this.floorNo = floorNo;
        this.spots = spots;
    }


    public ParkingSpot findSpot(VehicleType type){
        for(ParkingSpot spot:spots){
            if(spot.getSpotType() ==type && spot.isAvailable()){
                return spot;
            }
        }
        return null;
    }




    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public void setSpots(List<ParkingSpot> spots) {
        this.spots = spots;
    }
}
