package vidmot;

import javafx.fxml.FXMLLoader;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

/**
 * Represents a coal piece on the game board.
 */
public class Kol extends Rectangle {

    /**
     * Constructor for Kol. Loads the FXML and catches exception
     */
    public Kol() {
        FXMLLoader fxmlLoader = new FXMLLoader(GoldApplication.class.getResource("kol-view.fxml"));
        fxmlLoader.setRoot(this);       // root of the UI tree set here
        fxmlLoader.setController(this); // controller set here instead of in the .fxml file
        try {
            fxmlLoader.load();          // UI tree loaded
        } catch (IOException exception) {
            System.err.println("Fann ekki kol-view.fxml");
        }
    }
}
