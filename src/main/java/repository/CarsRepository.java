package repository;

import domain.ClientCar;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarsRepository {

    public Map<Integer, ClientCar> carsInParking = new HashMap<>();

    /**
     * Creates a new ClientCar
     * @param newCar the new added car
     * @throws Exception if the car already exists
     */
    public void createClientCar(ClientCar newCar) throws Exception {
        if (this.carsInParking.containsKey(newCar.getIdClientCar())) {
            throw new Exception("This car is already in the parking");
        }
        this.carsInParking.put(newCar.getIdClientCar(), newCar);
    }

    /**
     * To read all car entities
     * @return a list of all cars
     */
    public List<ClientCar> read() {
        return new ArrayList<>(this.carsInParking.values());
    }
}
