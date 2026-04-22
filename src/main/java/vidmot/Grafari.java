package vidmot;

import javafx.fxml.FXMLLoader;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

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

    public void setStefna(Stefna stefna) {
        this.stefna = stefna;
    }

    public Stefna getStefna() {
        return stefna;
    }

}
