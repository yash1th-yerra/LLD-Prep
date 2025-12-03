package parkinglot.strategy.pricing;

import parkinglot.enums.VehicleType;

import java.time.LocalDateTime;

public interface PricingStrategy  {
    double calculateFee(VehicleType vehicleType, LocalDateTime entryTime,LocalDateTime exitTime);
}
