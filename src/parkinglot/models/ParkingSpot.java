package parkinglot.models;

import parkinglot.enums.VehicleType;

import java.util.concurrent.atomic.AtomicBoolean;

public class ParkingSpot {


    private final String spotId;
    private final VehicleType allowedType;

    private AtomicBoolean occupied =new AtomicBoolean(false);
    public ParkingSpot(String spotId,VehicleType vehicleType){
        this.spotId = spotId;
        this.allowedType = vehicleType;
    }


    public String getSpotId(){
        return this.spotId;
    }

    public VehicleType getAllowedType(){
        return this.allowedType;
    }

    public boolean tryOccupy(){
        return occupied.compareAndSet(false,true);
    }

    public void vacate(){
        occupied.set(false);
    }

    public boolean isOccupied(){
        return occupied.get();
    }
}
