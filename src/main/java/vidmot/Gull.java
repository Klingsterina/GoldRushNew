package vidmot;

import javafx.fxml.FXMLLoader;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class Gull extends Rectangle {

    /**
     * Constructor for Gull. Loads the FXML and catches exception
     */
    public Gull() {
        FXMLLoader fxmlLoader = new FXMLLoader(GoldApplication.class.getResource("gull-view.fxml"));
        fxmlLoader.setRoot(this);       // rótin á viðmótstrénu sett hér
        fxmlLoader.setController(this); // controllerinn hér en ekki í .fxml skránni
        try {
            fxmlLoader.load();          // viðmótstréð lesið inn
        } catch (IOException exception) {
            System.err.println("Fann ekki gull-view.fxml");
        }
    }
}
