package parkinglot.factory;

import parkinglot.enums.VehicleType;
import parkinglot.models.Car;
import parkinglot.models.Vehicle;

public class VehicleFactory {
    public static Vehicle createVehicle(String number, VehicleType vehicleType){
        return switch(vehicleType){
            case CAR -> new Car(number);
            case BIKE -> new Car(number);
            case TRUCK-> new Car(number);
        };
    }
}
