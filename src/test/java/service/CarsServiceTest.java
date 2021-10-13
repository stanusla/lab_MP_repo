package service;

import domain.ClientCar;
import domain.ClientCarValidator;
import org.junit.jupiter.api.Test;
import repository.CarsRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsServiceTest {


//    CarsRepository carsRepository = new CarsRepository();
//    ClientCarValidator clientCarValidator = new ClientCarValidator();
//    CarsService carsService = new CarsService(carsRepository, clientCarValidator);

    @Test
    void testGetCarsByLicensePlateOK() {
        CarsRepository carsRepository = new CarsRepository();
    ClientCarValidator clientCarValidator = new ClientCarValidator();
    CarsService carsService = new CarsService(carsRepository, clientCarValidator);

        try {
            carsService.addClientCar(1, "CJ07ABC");
            carsService.addClientCar(2, "AB07CCC");
            carsService.addClientCar(3, "CJ02ABC");
            carsService.addClientCar(4, "CJ01BBB");
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<ClientCar> carsWithPrefix = carsService.getCarsByLicensePlate("CJ");
        assertTrue(carsWithPrefix.size() == 3, "There should be 3 cars with CJ licence plates !");

    }

}