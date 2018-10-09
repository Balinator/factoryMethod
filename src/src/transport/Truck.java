package src.transport;

/**
 * Created by Balinator on 2018. 10. 09..
 */
public class Truck extends Transport {

    @Override
    public void load() {
        System.out.println("Truck loaded, capacity = " + getCapacity() + " tones");
    }

    @Override
    public void goTo(String location) {
        System.out.println("Truck arrived to " + location);
    }

    @Override
    public void unload() {
        System.out.println("Truck unloaded, capacity = " + getCapacity());
    }

    @Override
    public void refuel() {
        System.out.println("Truck refueled, fuel = " + getFuel());
    }
}
