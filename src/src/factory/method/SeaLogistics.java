package src.factory.method;

import src.transport.ITransport;
import src.transport.Ship;

/**
 * Created by Balinator on 2018. 10. 09..
 */
public class SeaLogistics extends Logistics {

    @Override
    public ITransport createTransport() {
        System.out.println("createTransport");
        return new Ship();
    }

    public ITransport createTransportWithFuel(double fuel) {
        System.out.println("createTransportWithFuel");
        Ship ship = new Ship();
        ship.setFuel(fuel);
        return ship;
    }

    public ITransport createTransportWithCapacity(double capacity) {
        System.out.println("createTransportWithCapacity");
        Ship ship = new Ship();
        ship.setCapacity(capacity);
        return ship;
    }

    public ITransport createTransportWithFuelAndCapacity(double fuel, double capacity) {
        System.out.println("createTransportWithFuelAndCapacity");
        Ship ship = new Ship();
        ship.setFuel(fuel);
        ship.setCapacity(capacity);
        return ship;
    }
}
