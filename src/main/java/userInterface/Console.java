package userInterface;

import domain.ClientCar;
import domain.ParkingReservation;
import domain.ParkingSpot;
import service.CarsService;
import service.ParkingService;
import service.ReservationService;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Console {
    private CarsService carsService;
    private ParkingService parkingService;
    private ReservationService reservationService;
    private Scanner scanner = new Scanner(System.in);


    public Console(CarsService carsService, ParkingService parkingService, ReservationService reservationService) {
        this.carsService = carsService;
        this.parkingService = parkingService;
        this.reservationService = reservationService;
    }

    private void showMenu() {
        System.out.println("1. Add a Car");
        System.out.println("2. Add a ParkingSpot");
        System.out.println("3. Add a Reservation");
        System.out.println("4. Show all cars");
        System.out.println("5. Show all parking spots");
        System.out.println("6. Show all parking reservations");
        System.out.println("7. SearchCarByLicencePlate");
        System.out.println("x. Exit");

    }

   public void startConsole() {
        while (true) {
            showMenu();
            System.out.println("Choose an option");
            String option = scanner.next();
            if (option.equals("1")) {
                this.handleAddCar();
            } else if (option.equals("2")) {
                this.handleAddParkingSpot();
            } else if (option.equals("3")) {
                this.handleReservation();
            } else if (option.equals("4")) {
                this.handleShowAllCars();
            } else if (option.equals("5")) {
                this.handleShowAllParkingSpots();
            }  else if (option.equals("6")) {
                this.handleShowAllReservations();
            }  else if (option.equals("7")) {
                this.handleSearchCarByLicencePlate();
            }
                else if (option.equals("x")) {
                    break;
            } else {
                System.out.println("Incorrect option please retry");
            }
        }
    }

    private void handleShowAllReservations() {
        for (ParkingReservation reservation: this.reservationService.getAllParkingReservations()) {
            System.out.println(reservation.toString());
        }
    }

    private void handleShowAllParkingSpots() {
        for (ParkingSpot parkingSpot : this.parkingService.getAllSpots()) {
            System.out.println(parkingSpot.toString());
        }
    }

    private void handleShowAllCars() {
        for (ClientCar clientCar : this.carsService.getAllCars()) {
            System.out.println(clientCar.toString());
        }
    }

    public void handleAddCar() {
        try {
            System.out.println("Insert id");
            int idCar = this.scanner.nextInt();
            System.out.println("Insert the LicencePlate");
            String licencePlate = this.scanner.next();

            this.carsService.addClientCar(idCar, licencePlate);
            System.out.println("Car successfully added");


        } catch (Exception exception) {
            System.out.println("Error occurred");
            System.out.println(exception.getMessage());
        }
    }

    public void handleAddParkingSpot() {
        try {
            System.out.println("Insert id");
            int idSpot = this.scanner.nextInt();
            System.out.println("Insert Name");
            String name = this.scanner.next();
            System.out.println("Insert the Price");
            int price = this.scanner.nextInt();


            this.parkingService.addParkingSpot(idSpot, name, price);
            System.out.println("ParkingSpot successfully added");


        } catch (Exception exception) {
            System.out.println("Error occurred");
            System.out.println(exception.getMessage());
        }
    }

    public void handleReservation() {
        try {
            System.out.println("Insert IdSpot ");
            int idSpot = this.scanner.nextInt();
            System.out.println("Insert the IdCar");
            int idCar = this.scanner.nextInt();
            System.out.println("Insert please the number of hours stayed");
            String longValue = scanner.next();
            LocalDateTime timeNow = LocalDateTime.now();
            LocalDateTime leavingTime = timeNow.plusHours(Long.valueOf(longValue));
            this.reservationService.addReservation(idSpot, idCar, leavingTime);
            System.out.println("Reservation successfully added");
        } catch (Exception exception) {
            System.out.println("Error occurred");
            System.out.println(exception.getMessage());
        }
    }
    public void handleSearchCarByLicencePlate() {
        System.out.println("Insert the start or the full LicencePlate");
        String searchPrefixlicencePlate = this.scanner.next();
        List<ClientCar> carsWithLicencePlate =  this.carsService.getCarsByLicensePlate(searchPrefixlicencePlate);
        System.out.println("The cars with licence plates starting with"+searchPrefixlicencePlate + " are: ");
        carsWithLicencePlate.stream().forEach(System.out::println);

//        for (ClientCar clientCar : carsWithLicencePlate) {
//            System.out.println(clientCar.toString());
//        }
    }


}
