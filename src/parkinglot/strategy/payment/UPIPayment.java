package parkinglot.strategy.payment;

import parkinglot.models.Ticket;

public class UPIPayment implements PaymentStrategy{
    @Override
    public boolean processPayment(Ticket ticket, double amount) {
        System.out.println("Paid $ "+amount+" for ticket "+ticket.getTicketId()+" via UPI ");
        return true;
    }
}
