package domain;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class ParkingReservationValidator {

    public void validate(ParkingReservation reservation) throws Exception {
        if (reservation.getDateTimeOfLeaving().isBefore(LocalDateTime.now())) {
            throw new Exception("Invalid date and time");
        }
    }
}

