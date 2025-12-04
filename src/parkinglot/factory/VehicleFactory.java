package parkinglot.factory;

import parkinglot.enums.VehicleType;
import parkinglot.models.Bike;
import parkinglot.models.Car;
import parkinglot.models.Truck;
import parkinglot.models.Vehicle;

public class VehicleFactory {
    public static Vehicle createVehicle(String number, VehicleType vehicleType){
        return switch(vehicleType){
            case CAR -> new Car(number);
            case BIKE -> new Bike(number);
            case TRUCK-> new Truck(number);
        };
    }
}
