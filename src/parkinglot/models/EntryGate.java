package parkinglot.models;

import parkinglot.enums.GateType;
import parkinglot.service.ParkingLot;

import java.time.LocalDateTime;

public class EntryGate extends Gate{
    public EntryGate(String gateId){
        super(gateId);
    }

    @Override
    public GateType getGateType(){
        return GateType.ENTRY;

    }

    // TODO: implement park vehicle functionality
    public Ticket parkVehicle(Vehicle vehicle, LocalDateTime entryTime){
        return ParkingLot.getInstance().parkVehicle(vehicle,entryTime);

    }


}
