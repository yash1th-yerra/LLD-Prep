package parkinglot.models;

import parkinglot.enums.PaymentStatus;

import java.time.LocalDateTime;

public class Ticket {

    private String ticketId;
    private Vehicle vehicle;
    private LocalDateTime entryTime;
    private String floorId;
    private String spotId;
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;

    private Ticket(Builder builder){
        this.ticketId = builder.ticketId;
        this.vehicle = builder.vehicle;
        this.entryTime = builder.entryTime;
        this.floorId = builder.floorId;
        this.spotId = builder.spotId;
        this.paymentStatus = builder.paymentStatus;


    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public String getFloorId() {
        return floorId;
    }

    public String getSpotId() {
        return spotId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus){
        this.paymentStatus = paymentStatus;
    }

    public static class Builder{
        private String ticketId;
        private Vehicle vehicle;
        private LocalDateTime entryTime;
        private String floorId;
        private String spotId;
        private PaymentStatus paymentStatus;




        public Builder setTicketId(String ticketId){
            this.ticketId = ticketId;
            return this;
        }

        public Builder vehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            return this;
        }

        public Builder entryTime(LocalDateTime entryTime) {
            this.entryTime = entryTime;
            return this;
        }

        public Builder floorId(String floorId) {
            this.floorId = floorId;
            return this;
        }

        public Builder spotId(String spotId) {
            this.spotId = spotId;
            return this;
        }

        public Builder paymentStatus(PaymentStatus paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }
    }

}
