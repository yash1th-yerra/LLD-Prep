package parkinglot.models;

import parkinglot.enums.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloor {

    private final String floorId;
    private final Map<String,ParkingSpot> spots = new HashMap<>();

    public ParkingFloor(String floorId){ this.floorId = floorId;  }


    public void addSpot(ParkingSpot spot){
        spots.put(spot.getSpotId(),spot);
    }

    public String getFloorId(){
        return this.floorId;
    }

    public Map<String,ParkingSpot> getSpots(){
        return this.spots;
    }

    public ParkingSpot findAvailableSpot(VehicleType vehicleType){
        for(ParkingSpot spot : spots.values()){
            if(spot.getAllowedType()==vehicleType && spot.tryOccupy()) return spot;
        }
        return null;
    }
}
