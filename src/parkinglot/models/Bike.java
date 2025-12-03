package parkinglot.models;

import parkinglot.enums.VehicleType;

public class Bike extends Vehicle{
    public Bike(String number){
        super(number, VehicleType.BIKE);
    }
}
