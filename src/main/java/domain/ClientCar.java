package domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class ClientCar {

    private Integer idClientCar;
    private String licencePlate;


    public ClientCar(Integer id, String licencePlate) {
        this.idClientCar = id;
        this.licencePlate = licencePlate;
    }

    public Integer getIdClientCar() {
        return idClientCar;
    }

    public void setIdClientCar(Integer idClientCar) {
        this.idClientCar = idClientCar;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientCar clientCar = (ClientCar) o;
        return Objects.equals(idClientCar, clientCar.idClientCar) && Objects.equals(licencePlate, clientCar.licencePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClientCar, licencePlate);
    }

    @Override
    public String toString() {
        return "ClientCar{" +
                "idClientCar=" + idClientCar +
                ", licencePlate='" + licencePlate + '\'' +
                '}';
    }
}

