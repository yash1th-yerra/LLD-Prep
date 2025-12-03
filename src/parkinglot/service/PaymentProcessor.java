package parkinglot.service;

import parkinglot.enums.PaymentStatus;
import parkinglot.models.Ticket;
import parkinglot.strategy.payment.PaymentStrategy;

public class PaymentProcessor {
    private final PaymentStrategy paymentStrategy;
    public PaymentProcessor(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }
    public boolean pay(Ticket ticket,double amount){
        boolean success = paymentStrategy.processPayment(ticket,amount);
        if(success) ticket.setPaymentStatus(PaymentStatus.SUCCESS);
        else{
            ticket.setPaymentStatus(PaymentStatus.FAILED);
            System.out.println("Payment failed for ticket: "+ticket.getTicketId());
        }
        return success;
    }

}
