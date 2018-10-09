package src.factory.method;

import src.transport.ITransport;
import src.transport.Truck;

/**
 * Created by Balinator on 2018. 10. 09..
 */
public class RoadLogistics extends Logistics {

    @Override
    public ITransport createTransport() {
        System.out.println("createTransport");
        return new Truck();
    }

    public ITransport createTransportWithFuel(double fuel) {
        System.out.println("createTransportWithFuel");
        Truck truck = new Truck();
        truck.setFuel(fuel);
        return truck;
    }

    public ITransport createTransportWithCapacity(double capacity) {
        System.out.println("createTransportWithCapacity");
        Truck truck = new Truck();
        truck.setCapacity(capacity);
        return truck;
    }


    public ITransport createTransportWithFuelAndCapacity(double fuel, double capacity) {
        System.out.println("createTransportWithFuelAndCapacity");
        Truck truck = new Truck();
        truck.setFuel(fuel);
        truck.setCapacity(capacity);
        return truck;
    }
}
