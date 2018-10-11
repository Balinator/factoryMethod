package src.factory.method;

import src.transport.ITransport;

/**
 * Created by Balinator on 2018. 10. 09..
 */
public abstract class Logistics {

    public abstract ITransport createTransport();
    public abstract ITransport createTransportWithFuel(double fuel);
    public abstract ITransport createTransportWithCapacity(double capacity);
    public abstract ITransport createTransportWithFuelAndCapacity(double fuel, double capacity);
}
