package kz.lakida.learn.oop.taxi;

public class Driver implements Comparable<Driver> {
    private Location location;
    private Status status;

    public Driver() {
    }

    public Driver(Location location, Status status) {
        this.location = location;
        this.status = status;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isAcceptingOrders() {
        return this.status == Status.FREE;
    }

    @Override
    public int compareTo(Driver o) {
        return 0;
    }

    public enum Status {
        FREE, BUSY
    }
}
