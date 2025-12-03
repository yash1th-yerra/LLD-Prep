package parkinglot.strategy.payment;

import parkinglot.models.Ticket;

public interface PaymentStrategy {
    boolean processPayment(Ticket ticket, double amount);
}
