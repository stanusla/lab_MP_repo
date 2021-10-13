package service;

import domain.ClientCar;
import domain.ParkingReservation;
import domain.ParkingReservationValidator;
import domain.ParkingSpot;
import repository.ParkingRepository;
import repository.ReservationsRepository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class ReservationService {

    private ReservationsRepository reservationRepository;
    private ParkingReservationValidator reservationValidator;
    private ParkingRepository parkingRepository;

    public ReservationService(ReservationsRepository repository, ParkingReservationValidator validator, ParkingRepository parkingRepository) {
        this.reservationRepository = repository;
        this.reservationValidator = validator;
        this.parkingRepository = parkingRepository;
    }

    /**
     * Adds a new reservation, first creates a Reservation object, then it is validated and
     * if the spot is not available the object is not created
     * @param idSpot the id of Parking Spot
     * @param idCar the id of the car
     * @param leaving the time of leaving
     * @throws Exception if the parking spot is already occupied by another car
     */
    public void addReservation(Integer idSpot, Integer idCar, LocalDateTime leaving) throws Exception {
        ParkingReservation reservation = new ParkingReservation(idCar, idSpot, leaving);
        this.reservationValidator.validate(reservation);
        if (!this.parkingRepository.parkingSpots.get(idSpot).isAvailable()) {
            throw new Exception("This spot is not available!");
        }
        this.reservationRepository.createReservation(reservation);
        this.parkingRepository.parkingSpots.get(idSpot).setAvailable(false);
    }

    /**
     * Shows all the reservations
     * @return a list of all reservations
     */
    public List<ParkingReservation> getAllParkingReservations() {
        return this.reservationRepository.getAllReservations();
    }
}
