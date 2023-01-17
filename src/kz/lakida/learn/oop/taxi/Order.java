package kz.lakida.learn.oop.taxi;

public class Order {
    private Location location;
    private String address;
    private Driver driver;
    private Status status;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double distanceToDriver(Driver driver) {
        return this.location.distance(driver.getLocation());
    }

    public enum Status {
        NEW, IN_PROGRESS, DONE
    }

}
