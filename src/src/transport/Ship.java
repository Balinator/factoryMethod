package src.transport;

/**
 * Created by Balinator on 2018. 10. 09..
 */
public class Ship extends Transport {

    @Override
    public void load() {
        System.out.println("Ship loaded, capacity = " + getCapacity() + " tones");
    }

    @Override
    public void goTo(String location) {
        System.out.println("Ship arrived to " + location);
    }

    @Override
    public void unload() {
        System.out.println("Ship unloaded, capacity = " + getCapacity());
    }

    @Override
    public void refuel() {
        System.out.println("Ship refueled, fuel = " + getFuel());
    }
}
