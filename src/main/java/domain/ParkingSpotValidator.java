package domain;

public class ParkingSpotValidator {

    public void validate(ParkingSpot parkingSpot) {
        if (parkingSpot.getPrice() < 0) {
            throw new Error("The price should be > 0");
        }
    }
}
