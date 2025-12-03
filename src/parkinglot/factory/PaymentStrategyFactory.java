package parkinglot.factory;

import parkinglot.enums.PaymentMode;
import parkinglot.strategy.payment.CardPayment;
import parkinglot.strategy.payment.CashPayment;
import parkinglot.strategy.payment.PaymentStrategy;
import parkinglot.strategy.payment.UPIPayment;

public class PaymentStrategyFactory {

    public static PaymentStrategy getInstance(PaymentMode paymentMode){
        return switch (paymentMode){
            case UPI -> new UPIPayment();
            case CASH-> new CashPayment();
            case CARD -> new CardPayment();
        };
    }
}
