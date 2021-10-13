package repository;

import domain.ParkingSpot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingRepository {

    public Map<Integer,ParkingSpot> parkingSpots = new HashMap<>();

    /**
     * Creates a new parking spot
     * @param newSpot the parking spot object
     * @throws Exception if the parking spot already exists
     */
    public void createParkingSpot(ParkingSpot newSpot) throws Exception {
        if (this.parkingSpots.containsKey(newSpot.getIdParkingSpot())) {
            throw new Exception("This spot already exists!");
        }
        this.parkingSpots.put(newSpot.getIdParkingSpot(), newSpot);
    }

    /**
     * To show all parking spots
     * @return a list of all parking spots
     */
    public List<ParkingSpot> readSpots() {
        return new ArrayList<>(this.parkingSpots.values());
    }


}
