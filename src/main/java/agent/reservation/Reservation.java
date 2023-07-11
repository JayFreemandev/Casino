package agent.reservation;

import agent.Client;

import java.time.LocalDate;

public class Reservation {
    private final Client client;
    private final String room;
    private final LocalDate checkInDate;
    private final LocalDate checkOutDate;

    public Reservation(Client client, String room, LocalDate checkInDate, LocalDate checkOutDate) {
        this.client = client;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }


    public Client getClient() {
        return client;
    }

    public String getRoom() {
        return room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public boolean isAleadyBooked(Reservation otherReservation) {
        return !checkOutDate.isBefore(otherReservation.getCheckInDate()) &&
                !checkInDate.isAfter(otherReservation.getCheckOutDate());
    }
}

