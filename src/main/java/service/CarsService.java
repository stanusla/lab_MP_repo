package service;

import domain.ClientCar;
import domain.ClientCarValidator;
import domain.ParkingSpot;
import repository.CarsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarsService {

    private CarsRepository carsRepository;
    private ClientCarValidator clientCarValidator;

    public CarsService(CarsRepository carsRepository, ClientCarValidator clientCarValidator) {
        this.carsRepository = carsRepository;
        this.clientCarValidator = clientCarValidator;
    }

    /**
     * Creates a new Client Car Object and after validation is added to the repository
     * @param id the id of the car
     * @param licencePlate the licence plate number which should be between 5-8 characters
     * @throws Exception if the car already exists
     */

    public void addClientCar(Integer id, String licencePlate) throws Exception {
        ClientCar newCar = new ClientCar(id, licencePlate);
        this.clientCarValidator.validate(newCar);
        this.carsRepository.createClientCar(newCar);
    }

    /**
     * Read all client cars
     * @return a list of all client cars
     */
    public List<ClientCar> getAllCars() {
        return this.carsRepository.read();
    }

    /**
     * Returns all the cars with the licence plate starting with prefixlicencePlate
     * @param prefixlicencePlate the prefix of the searched licence
     * @return
     */
    public List<ClientCar> getCarsByLicensePlate(String prefixlicencePlate) {
        List<ClientCar> allCars = this.carsRepository.read();
        List<ClientCar> carsWitPrefix = allCars.stream().filter(e-> e.getLicencePlate().startsWith(prefixlicencePlate)).collect(Collectors.toList());

//        List<ClientCar> carsWitPrefix2 = new ArrayList<>();
//        for(ClientCar car : allCars) {
//            if(car.getLicencePlate().startsWith(prefixlicencePlate)) {
//                carsWitPrefix2.add(car);
//            }
//        }

        return carsWitPrefix;
    }


}
