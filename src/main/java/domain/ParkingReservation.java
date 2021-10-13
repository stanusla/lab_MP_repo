package domain;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class ParkingReservation {

    private Integer idClientCar;
    private Integer idParkingSpot;
    private LocalDateTime dateTimeOfEntry;
    private LocalDateTime dateTimeOfLeaving;

    public ParkingReservation(Integer idClientCar, Integer idParkingSpot, LocalDateTime dateTimeOfLeaving) {
        this.idClientCar = idClientCar;
        this.idParkingSpot = idParkingSpot;
        this.dateTimeOfEntry = LocalDateTime.now();
        this.dateTimeOfLeaving = dateTimeOfLeaving;
    }

    public Integer getIdClientCar() {
        return idClientCar;
    }

    public void setIdClientCar(Integer idClientCar) {
        this.idClientCar = idClientCar;
    }

    public Integer getIdParkingSpot() {
        return idParkingSpot;
    }

    public void setIdParkingSpot(Integer idParkingSpot) {
        this.idParkingSpot = idParkingSpot;
    }

    public LocalDateTime getDateTimeOfEntry() {
        return dateTimeOfEntry;
    }

    public void setDateTimeOfEntry(LocalDateTime dateTimeOfEntry) {
        this.dateTimeOfEntry = dateTimeOfEntry;
    }

    public LocalDateTime getDateTimeOfLeaving() {
        return dateTimeOfLeaving;
    }

    public void setDateTimeOfLeaving(LocalDateTime dateTimeOfLeaving) {
        this.dateTimeOfLeaving = dateTimeOfLeaving;
    }

    @Override
    public String toString() {
        return "ParkingReservation{" +
                "idClientCar=" + idClientCar +
                ", idParkingSpot=" + idParkingSpot +
                ", dateTimeOfEntry=" + dateTimeOfEntry +
                ", dateTimeOfLeaving=" + dateTimeOfLeaving +
                '}';
    }
}


