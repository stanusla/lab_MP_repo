package domain;

public class ClientCarValidator {

public void validate(ClientCar carToValidate) {
    if (carToValidate.getLicencePlate().isEmpty()) {
        throw new Error("Licence plate must have between 5-8 characters");
    }
    if (carToValidate.getLicencePlate().length() < 5) {
        throw new Error("Licence plate must have between 5-8 characters");
    }
    if (carToValidate.getLicencePlate().length() > 8) {
        throw new Error("Licence plate must contains between 5-8 characters");
    }
}
}
