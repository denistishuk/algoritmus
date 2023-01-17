package kz.lakida.learn.oop.taxi;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class DriverManager {

    private final Set<Driver> drivers;

    public DriverManager(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    public void add(Driver driver) {
        drivers.add(driver);
    }

    public Iterable<Driver> calculateForOrder(Order order) {
        PriorityQueue<Driver> driverQueue = new PriorityQueue<>(new DriverQueueComparator(order));
        Set<Driver> freeDrivers = new HashSet<>();
        for (Driver driver : drivers) {
            if (driver.isAcceptingOrders()) {
                freeDrivers.add(driver);
            }
        }
        driverQueue.addAll(freeDrivers);
        return driverQueue;
    }

    private static class DriverQueueComparator implements Comparator<Driver> {

        private final Order order;

        private DriverQueueComparator(Order order) {
            this.order = order;
        }

        @Override
        public int compare(Driver d1, Driver d2) {
            double distanceToDriver1 = order.distanceToDriver(d1);
            double distanceToDriver2 = order.distanceToDriver(d2);
            return Double.compare(distanceToDriver1, distanceToDriver2);
        }
    }
}
