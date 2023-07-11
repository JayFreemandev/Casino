package agent.reservation;

import java.util.Optional;

public interface ReservationService {
    Optional<Reservation> makeReservation(Reservation reservation);

    boolean cancelReservation(Reservation reservation);
}
