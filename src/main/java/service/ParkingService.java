package service;

import domain.ParkingSpot;
import domain.ParkingSpotValidator;
import repository.ParkingRepository;

import java.util.List;

public class ParkingService {

    private ParkingRepository parkingRepository;
    private ParkingSpotValidator parkingSpotValidator;

    public ParkingService(ParkingRepository parkingRepository, ParkingSpotValidator validator) {
        this.parkingRepository = parkingRepository;
        this.parkingSpotValidator = validator;
    }

    /**
     *  * Creates a new ParkingSpot Object and after validation is added to the repository
     * @param id the id of the parking spot
     * @param name the name of the spot
     * @param price the price of the parking spot
     * @throws Exception if the parking spot is already added
     */
    public void addParkingSpot(Integer id, String name, Integer price) throws Exception {
        ParkingSpot newSpot = new ParkingSpot(id, name, price);
        this.parkingSpotValidator.validate(newSpot);
        this.parkingRepository.createParkingSpot(newSpot);
    }

    /**
     * Reads all the parking spots registered
     * @return a list of all parking spots
     */
    public List<ParkingSpot> getAllSpots() {
        return this.parkingRepository.readSpots();
    }
}
