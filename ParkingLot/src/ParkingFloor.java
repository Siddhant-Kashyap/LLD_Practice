import java.util.List;

public class ParkingFloor {
    public int floorId;
    public List<ParkingSpot> parkingSpots;

    public  ParkingFloor(int floorId, List<ParkingSpot> spots){
        this.floorId=floorId;
        this.parkingSpots=spots;
    }

}
