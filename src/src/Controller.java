package src;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import javafx.scene.control.*;
import javafx.util.Duration;
import src.factory.method.AirLogistics;
import src.factory.method.Logistics;
import src.factory.method.RoadLogistics;
import src.factory.method.SeaLogistics;
import src.transport.ITransport;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class Controller {

    private static final String REGEX = "\\d{0,7}([\\.]\\d{0,4})?";

    private int x = 0;
    private int y = 0;

    @FXML
    private ChoiceBox<String> type;

    @FXML
    private TextField fuel;

    @FXML
    private TextField capacity;

    @FXML
    private TextField address;


    @FXML
    private TextArea output;


    @FXML
    private void initialize() {
        Console console = new Console(output);
        PrintStream ps = new PrintStream(console, true);
        System.setOut(ps);

        fuel.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches(REGEX)) {
                fuel.setText(oldValue);
            }
        });

        capacity.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches(REGEX)) {
                capacity.setText(oldValue);
            }
        });
    }

    @FXML
    private void printOutput() {
        if(this.type != null && this.address != null && !this.address.getText().isEmpty()) {
            Logistics logistics;
            switch (this.type.getValue()) {
                case "Road":
                    logistics = new RoadLogistics();
                    break;
                case "Sea":
                    logistics = new SeaLogistics();
                    break;
                case "Air":
                    logistics = new AirLogistics();
                    break;
                default:
                    return;
            }

            boolean isFuel = !this.fuel.getText().isEmpty();
            boolean isCapacity = !this.capacity.getText().isEmpty();

            if(isFuel) {
                double fuel = Double.parseDouble(this.fuel.getText());
                if(isCapacity) {
                    double capacity = Double.parseDouble(this.capacity.getText());
                    doTheWork(logistics, logistics.createTransportWithFuelAndCapacity(fuel, capacity));
                    return;
                }
                doTheWork(logistics, logistics.createTransportWithFuel(fuel));
                return;
            } else if(isCapacity) {
                double capacity = Double.parseDouble(this.capacity.getText());
                doTheWork(logistics, logistics.createTransportWithCapacity(capacity));
                return;
            }
            doTheWork(logistics, logistics.createTransport());
        } else {
            Timeline timelineX = new Timeline(new KeyFrame(Duration.seconds(0.1), t -> {
                if (x == 0) {
                    Controller.this.type.setTranslateX(Controller.this.type.getTranslateX() + 10);
                    Controller.this.address.setTranslateX(Controller.this.address.getTranslateX() + 10);
                    x = 1;
                } else {
                    Controller.this.type.setTranslateX(Controller.this.type.getTranslateX() - 10);
                    Controller.this.address.setTranslateX(Controller.this.address.getTranslateX() - 10);
                    x = 0;
                }
            }));

            timelineX.setCycleCount(6);
            timelineX.setAutoReverse(false);
            timelineX.play();

        }
    }

    private void doTheWork(Logistics logistics, ITransport transport) {
        transport.load();
        transport.goTo(this.address.getText());
        transport.unload();
        transport.goTo("warehouse");
        transport.refuel();
        System.out.println();
    }
}

class Console extends OutputStream {
    private TextArea    output;

    Console(TextArea ta)
    {
        this.output = ta;
    }

    @Override
    public void write(int i) throws IOException
    {
        output.appendText(String.valueOf((char) i));
    }

}