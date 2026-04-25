package vidmot;

import javafx.fxml.FXMLLoader;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

/**
 * Represents a gold piece on the game board.
 */
public class Gull extends Rectangle {

    /**
     * Constructor for Gull. Loads the FXML and catches exception
     */
    public Gull() {
        FXMLLoader fxmlLoader = new FXMLLoader(GoldApplication.class.getResource("gull-view.fxml"));
        fxmlLoader.setRoot(this);       // root of the UI tree set here
        fxmlLoader.setController(this); // controller set here instead of in the .fxml file
        try {
            fxmlLoader.load();          // UI tree loaded
        } catch (IOException exception) {
            System.err.println("Fann ekki gull-view.fxml");
        }
    }
}
