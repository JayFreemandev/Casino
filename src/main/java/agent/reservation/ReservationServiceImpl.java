package agent.reservation;

import agent.exception.AgentException;
import agent.exception.AgentExceptionType;

import java.util.List;
import java.util.Optional;

public class ReservationServiceImpl implements ReservationService {
    private final List<Reservation> reservations;

    public ReservationServiceImpl(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public Optional<Reservation> makeReservation(Reservation reservation) {
        if (isReservationOverlapping(reservation)) {
            throw new AgentException(AgentExceptionType.INVALID_CUSTOMER);
        }
        reservations.add(reservation);
        return Optional.of(reservation);
    }

    @Override
    public boolean cancelReservation(Reservation reservation) {
        return reservations.remove(reservation);
    }

    private boolean isReservationOverlapping(Reservation newReservation) {
        for (Reservation existingReservation : reservations) {
            if (existingReservation.isAlreadyBooked(newReservation)) {
                return true;
            }
        }
        return false;
    }
}
