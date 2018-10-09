package src.transport;

/**
 * Created by Balinator on 2018. 10. 09..
 */
public class Plane extends Transport {

    @Override
    public void load() {
        System.out.println("Plane loaded, capacity = " + getCapacity() + " tones");
    }

    @Override
    public void goTo(String location) {
        System.out.println("Plane arrived to " + location);
    }

    @Override
    public void unload() {
        System.out.println("Plane unloaded, capacity = " + getCapacity());
    }

    @Override
    public void refuel() {
        System.out.println("Plane refueled, fuel = " + getFuel());
    }
}
