package com.reservation.model;

public class Reservation {

    private int reservationId;
    private int userId;
    private int trainId;
    private String journeyDate;
    private int numberOfSeats;
    private String status;

    public Reservation() {
    }

    public Reservation(int reservationId, int userId, int trainId,
                       String journeyDate, int numberOfSeats, String status) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.trainId = trainId;
        this.journeyDate = journeyDate;
        this.numberOfSeats = numberOfSeats;
        this.status = status;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(String journeyDate) {
        this.journeyDate = journeyDate;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", userId=" + userId +
                ", trainId=" + trainId +
                ", journeyDate='" + journeyDate + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", status='" + status + '\'' +
                '}';
    }
}