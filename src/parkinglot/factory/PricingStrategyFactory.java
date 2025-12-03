package parkinglot.factory;

import parkinglot.enums.PricingStrategyType;
import parkinglot.strategy.pricing.EventBasedPricing;
import parkinglot.strategy.pricing.PricingStrategy;
import parkinglot.strategy.pricing.TimeBasedPricing;

public class PricingStrategyFactory {

    public static PricingStrategy get(PricingStrategyType pricingStrategyType){
        return switch(pricingStrategyType){
            case TIME_BASED -> new TimeBasedPricing();
            case EVENT_BASED -> new EventBasedPricing();
        };
    }
}
