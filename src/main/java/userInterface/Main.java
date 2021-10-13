package userInterface;

import domain.ClientCarValidator;
import domain.ParkingReservationValidator;
import domain.ParkingSpotValidator;
import repository.CarsRepository;
import repository.ParkingRepository;
import repository.ReservationsRepository;
import service.CarsService;
import service.ParkingService;
import service.ReservationService;

public class Main {
    public static void main(String[] args) {
        CarsRepository carsRepository = new CarsRepository();
        ClientCarValidator clientCarValidator = new ClientCarValidator();
        CarsService carsService = new CarsService(carsRepository, clientCarValidator);

        ParkingRepository parkingRepository = new ParkingRepository();
        ParkingSpotValidator parkingSpotValidator = new ParkingSpotValidator();
        ParkingService parkingService = new ParkingService(parkingRepository, parkingSpotValidator);

        ReservationsRepository reservationsRepository = new ReservationsRepository();
        ParkingReservationValidator parkingReservationValidator = new ParkingReservationValidator();
        ReservationService reservationService = new ReservationService(reservationsRepository, parkingReservationValidator, parkingRepository);

        Console console = new Console(carsService, parkingService, reservationService);
        console.startConsole();


    }
}
