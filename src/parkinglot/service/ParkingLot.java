package parkinglot.service;

import parkinglot.enums.PaymentMode;
import parkinglot.enums.PaymentStatus;
import parkinglot.enums.PricingStrategyType;
import parkinglot.factory.PaymentStrategyFactory;
import parkinglot.factory.PricingStrategyFactory;
import parkinglot.models.ParkingFloor;
import parkinglot.models.ParkingSpot;
import parkinglot.models.Ticket;
import parkinglot.models.Vehicle;
import parkinglot.strategy.payment.PaymentStrategy;
import parkinglot.strategy.pricing.PricingStrategy;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParkingLot {

    private static final ParkingLot INSTANCE = new ParkingLot();

    private final Map<String, ParkingFloor> floors = new HashMap<>();
    private final Map<String, Ticket> activeTickets = new HashMap<>();

    private PricingStrategy pricingStrategy;

    private ParkingLot(){
        this.pricingStrategy = PricingStrategyFactory.get(PricingStrategyType.TIME_BASED);
    }

    public static ParkingLot getInstance(){
        return INSTANCE;
    }

    public void addFloor(ParkingFloor floor){
        floors.put(floor.getFloorId(),floor);
    }


    public void setPricingStrategy(PricingStrategy pricingStrategy){
        this.pricingStrategy = pricingStrategy;
    }


    // Park Vehicle Implementation
    public Ticket parkVehicle(Vehicle vehicle, LocalDateTime entryTime){
        for(ParkingFloor floor : floors.values()){
            ParkingSpot spot = floor.findAvailableSpot(vehicle.getVehicleType());

            if(spot!=null){
                String ticketId = UUID.randomUUID().toString();
                Ticket ticket =new Ticket.Builder()
                                .setTicketId(ticketId).vehicle(vehicle)
                                .entryTime(entryTime)
                                .floorId(floor.getFloorId())
                                .spotId(spot.getSpotId())
                                .paymentStatus(PaymentStatus.PENDING)
                                .build();

                activeTickets.put(ticketId,ticket);
                System.out.println("Vehicle Parked. Ticket: "+ticketId);
                return ticket;
            }
        }
        System.out.println("No Parking Spot available for vehicle type: "+vehicle.getVehicleType());
        return null;
    }


    // Unpark Vehicle Implementation

    public void unParkVehicle(String ticketId, LocalDateTime exitTime, PaymentMode paymentMode){
        Ticket ticket = activeTickets.get(ticketId);
        if(ticket==null){
            System.out.println("Invalid Ticket ID");
            return;
        }

        double fee = pricingStrategy.calculateFee(
                ticket.getVehicle().getVehicleType(),ticket.getEntryTime(),exitTime
        );
        PaymentStrategy strategy = PaymentStrategyFactory.getInstance(paymentMode);
        PaymentProcessor paymentProcessor = new PaymentProcessor(strategy);
        boolean paid = paymentProcessor.pay(ticket,fee);


        if(!paid){
            System.out.println("Vehicle cannot exit. Payment Unsuccessful");
            return;
        }
        ParkingSpot spot = floors.get(ticket.getFloorId()).getSpots().get(ticket.getSpotId());
        spot.vacate();
        activeTickets.remove(ticketId);
        System.out.println("Vehicle Exited . Fee charged: "+fee);
    }


    // print status

    public void printStatus(){
        floors.forEach((floorId,floor)->{
            System.out.println("Floor: "+floorId);
            floor.getSpots().values().forEach(spot->{
                System.out.println(" Spot "+spot.getSpotId()+ " [ "+spot.getAllowedType()+ " ] - " + (spot.isOccupied()?"Occupied ":"Free "));
            });
        });
    }

}
