package src.factory.method;

import src.transport.ITransport;
import src.transport.Plane;

/**
 * Created by Balinator on 2018. 10. 09..
 */
public class AirLogistics extends Logistics {

    @Override
    public ITransport createTransport() {
        System.out.println("createTransport");
        return new Plane();
    }

    public ITransport createTransportWithFuel(double fuel) {
        System.out.println("createTransportWithFuel");
        Plane plane = new Plane();
        plane.setFuel(fuel);
        return plane;
    }

    public ITransport createTransportWithCapacity(double capacity) {
        System.out.println("createTransportWithCapacity");
        Plane plane = new Plane();
        plane.setCapacity(capacity);
        return plane;
    }

    public ITransport createTransportWithFuelAndCapacity(double fuel, double capacity) {
        System.out.println("createTransportWithFuelAndCapacity");
        Plane plane = new Plane();
        plane.setFuel(fuel);
        plane.setCapacity(capacity);
        return plane;
    }
}
