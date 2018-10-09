package src.factory.method;

import src.transport.ITransport;

/**
 * Created by Balinator on 2018. 10. 09..
 */
public abstract class Logistics {

    private ITransport transport;

    public abstract ITransport createTransport();
    public abstract ITransport createTransportWithFuel(double fuel);
    public abstract ITransport createTransportWithCapacity(double capacity);
    public abstract ITransport createTransportWithFuelAndCapacity(double fuel, double capacity);

    public void deliverTo(String location) {
        this.transport.load();
        this.transport.goTo(location);
        this.transport.unload();
        this.transport.goTo("warehouse");
        this.transport.refuel();
    }

    public void planRout(ITransport transport) {
        this.transport = transport;
    }
}
