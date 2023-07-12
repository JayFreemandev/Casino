package agent;

import agent.reservation.Reservation;
import agent.reservation.ReservationService;
import agent.reservation.ReservationServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Nested
@DisplayName("ReservationService 클래스 테스트")
public class ReservationServiceTest {
    @Test
    @DisplayName("예약 생성 테스트")
    public void testMakeReservation() {
        // Given
        List<Reservation> reservations = new ArrayList<>();
        Client client = new Client("Jay Freeman", "롯데타워");
        Reservation reservation = new Reservation(client, "스페셜룸", LocalDate.now(), LocalDate.now().plusDays(2));
        ReservationService reservationService = new ReservationServiceImpl(reservations);

        // When
        Optional<Reservation> createdReservation = reservationService.makeReservation(reservation);

        // Then
        assertTrue(createdReservation.isPresent());
        assertTrue(reservations.contains(reservation));
    }

    @Test
    @DisplayName("예약 취소 테스트")
    public void testCancelReservation() {
        // Given
        List<Reservation> reservations = new ArrayList<>();
        Client client = new Client("Jay Freeman", "롯데타워");
        Reservation reservation = new Reservation(client, "게스트하우스", LocalDate.now(), LocalDate.now().plusDays(2));
        ReservationService reservationService = new ReservationServiceImpl(reservations);
        reservations.add(reservation);

        // When
        boolean canceled = reservationService.cancelReservation(reservation);

        // Then
        assertTrue(canceled);
        assertFalse(reservations.contains(reservation));
    }
}