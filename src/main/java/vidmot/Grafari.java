package vidmot;

import javafx.fxml.FXMLLoader;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

/**
 * Represents a player character on the game board.
 */
public class Grafari extends Rectangle {
    private Stefna stefna = Stefna.KYRR; // Instance of enum Stefna

    /**
     * Constructor for Grafari. Loads the FXML and catches exception
     */
    public Grafari() {
        FXMLLoader fxmlLoader = new FXMLLoader(GoldApplication.class.getResource("grafari-view.fxml"));
        fxmlLoader.setRoot(this);   // rótin á viðmótstrénu sett hér
        fxmlLoader.setController(this); // controllerinn settur hér en ekki í .fxml skránni
        try {
            fxmlLoader.load();          // viðmótstréð lesið inn (þ.e. .fxml skráin)
        } catch (IOException exception) {
            System.err.println("Fann ekki grafari-view.fxml");
        }
    }

    /**
     * Sets the movement direction of the player.
     *
     * @param stefna the direction to move
     */
    public void setStefna(Stefna stefna) {
        this.stefna = stefna;
    }

    /**
     * Returns the current movement direction of the player.
     *
     * @return the current direction
     */
    public Stefna getStefna() {
        return stefna;
    }

}
