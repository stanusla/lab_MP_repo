package domain;

import java.util.Objects;

public class ParkingSpot {
    private Integer idParkingSpot;
    private String name;
    private boolean isAvailable;
    private Integer price;

    public ParkingSpot(int id, String name, Integer price) {
        this.idParkingSpot = id;
        this.name = name;
        this.isAvailable = true;
        this.price = price;
    }

    public Integer getIdParkingSpot() {
        return idParkingSpot;
    }

    public void setIdParkingSpot(Integer idParkingSpot) {
        this.idParkingSpot = idParkingSpot;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Integer getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingSpot that = (ParkingSpot) o;
        return isAvailable == that.isAvailable && Objects.equals(idParkingSpot, that.idParkingSpot) && Objects.equals(name, that.name) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idParkingSpot, name, isAvailable, price);
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "idParkingSpot=" + idParkingSpot +
                ", name='" + name + '\'' +
                ", isAvailable=" + isAvailable +
                ", price=" + price +
                '}';
    }
}
