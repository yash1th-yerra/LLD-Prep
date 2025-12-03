package parkinglot.models;

import parkinglot.enums.VehicleType;


public abstract class Vehicle {
    private final String vehicleNumber;
    private final VehicleType vehicleType;

    public Vehicle(String vehicleNumber,VehicleType vehicleType){
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }
    public String getVehicleNumber(){
        return this.vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
