package src.transport;

/**
 * Created by Balinator on 2018. 10. 09..
 */
public interface ITransport {

    void load();

    void goTo(String location);

    void unload();

    void refuel();
}
