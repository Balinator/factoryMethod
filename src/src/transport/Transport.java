package src.transport;

/**
 * Created by Balinator on 2018. 10. 09..
 */
public abstract class Transport implements ITransport {

    private double fuel;
    private double capacity;

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
}
