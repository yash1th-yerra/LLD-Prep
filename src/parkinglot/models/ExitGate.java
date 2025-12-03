package parkinglot.models;

import parkinglot.enums.GateType;
import parkinglot.enums.PaymentMode;
import parkinglot.service.ParkingLot;

import java.time.LocalDateTime;

public class ExitGate extends Gate{

    public ExitGate(String gateId){
        super(gateId);
    }

    @Override
    public GateType getGateType(){
        return GateType.EXIT;
    }

    // TODO: implement unpark vehicle functionality
    public void unparkVehicle(String ticketId, LocalDateTime exitTime, PaymentMode paymentMode){
        ParkingLot.getInstance().unParkVehicle(ticketId,exitTime,paymentMode);
    }
}
