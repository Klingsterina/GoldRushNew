package vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vinnsla.Leikur;

/**
 * Controller for the main menu screen.
 */
public class MainMenuController {

    /** Default constructor. */
    public MainMenuController() {}

    /**
     * Initializes the main menu controller.
     */
    public void initialize() {
    }

    // Button handler for selecting one player
    @FXML
    private void handleOnePlayer(ActionEvent event) {
        Leikur.tveirSpilarar = false;
        swapToGame(event);
    }

    // Button handler for selecting two players
    @FXML
    private void handleTwoPlayer(ActionEvent event) {
        Leikur.tveirSpilarar = true;
        swapToGame(event);
    }

    // Switches to the main game view
    private void swapToGame(ActionEvent event) {
        try {
            // Load the FXML for the sample scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("goldrush-view.fxml"));
            Parent sampleRoot = loader.load();
            Scene sampleScene = new Scene(sampleRoot);

            // Get the current stage (window) using the event's source
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            GoldController controller = loader.getController();
            controller.setStage(stage);

            // Set the new scene on the current stage
            stage.setScene(sampleScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}