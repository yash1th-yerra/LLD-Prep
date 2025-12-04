package parkinglot;

import parkinglot.enums.PaymentMode;
import parkinglot.enums.PricingStrategyType;
import parkinglot.enums.VehicleType;
import parkinglot.factory.PricingStrategyFactory;
import parkinglot.factory.VehicleFactory;
import parkinglot.models.*;
import parkinglot.service.ParkingLot;
import parkinglot.utils.DateTimeParser;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        EntryGate entryGate = new EntryGate("EG1");
        ExitGate exitGate = new ExitGate("XG1");
        Ticket[] capturedTickets = new Ticket[5];

        ParkingFloor parkingFloor1 = new ParkingFloor("floor1");
        parkingFloor1.addSpot(new ParkingSpot("F1S1", VehicleType.CAR));
        parkingFloor1.addSpot(new ParkingSpot("F1S2", VehicleType.BIKE));
        parkingFloor1.addSpot(new ParkingSpot("F1S3", VehicleType.TRUCK));
        parkingFloor1.addSpot(new ParkingSpot("F1S4", VehicleType.CAR));
        parkingLot.addFloor(parkingFloor1);
        parkingLot.setPricingStrategy(PricingStrategyFactory.get(PricingStrategyType.TIME_BASED));


        System.out.println("-----------------------------");

        Vehicle bike1 = VehicleFactory.createVehicle("KA01AB1234", VehicleType.BIKE);
        Vehicle bike2 = VehicleFactory.createVehicle("KA01AB5678", VehicleType.BIKE);

        LocalDateTime entryTime = DateTimeParser.parse("03 Dec 1:22 PM 2025");
        System.out.println(entryTime.truncatedTo(ChronoUnit.HOURS));

        Thread t1 = new Thread(() -> capturedTickets[0] = entryGate.parkVehicle(bike1, entryTime));
        Thread t2 = new Thread(() -> capturedTickets[1] = entryGate.parkVehicle(bike2, entryTime));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            // ... handle exception
            System.out.println(e.fillInStackTrace());
        }

        LocalDateTime exitTime = DateTimeParser.parse("05 Dec 1:53 PM 2025");
        exitGate.unparkVehicle(capturedTickets[0].getTicketId(),exitTime, PaymentMode.UPI);

        System.out.println("-----------------------------");
        parkingLot.printStatus();




    }
}
