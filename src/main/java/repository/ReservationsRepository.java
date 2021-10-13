package repository;

import domain.ParkingReservation;
import domain.ParkingSpot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationsRepository {

    public Map<Integer,ParkingReservation> reservations = new HashMap<>();

    /**
     * Creates a new Reservation
     * @param newReservation the reservation Object
     * @throws Exception if the reservation was already made
     */
    public void createReservation(ParkingReservation newReservation) throws Exception {
        if (this.reservations.containsKey(newReservation.getIdClientCar())) {
            throw new Exception("This reservation already exists!");
        }
        this.reservations.put(newReservation.getIdClientCar(), newReservation);
    }

    /**
     * Reads all the reservations
     * @return a list of all reservations
     */
    public List<ParkingReservation> getAllReservations() {
        return new ArrayList<>(this.reservations.values());
    }
}
