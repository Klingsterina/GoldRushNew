package vinnsla;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import vidmot.Stefna;

import java.util.HashMap;

/**
 * Represents a player in the game. Handles key bindings and tracks the player's score.
 */
public class Spilari {
    public final HashMap<KeyCode, Stefna> attir = new HashMap<>(); // Makes a map for keycodes and directions for player 1
    public final HashMap<KeyCode, Boolean> virkirTakkar = new HashMap<>(); // Makes a map for registering currently held keys for player 1
    private final SimpleIntegerProperty stig = new SimpleIntegerProperty(); // Simple Integer property for score

    /**
     * Handles a key press or release event and returns the resulting direction.
     * Returns null if the key is not bound to this player.
     *
     * @param event the key event to handle
     * @return the direction the player should move, or null if the key is unbound
     */
    public Stefna yttATakka(KeyEvent event) {
        if (attir.containsKey(event.getCode())) {
            if (event.getEventType() == KeyEvent.KEY_PRESSED) {
                virkirTakkar.put(event.getCode(), true);
                return attir.get(event.getCode());
            } else if (event.getEventType() == KeyEvent.KEY_RELEASED) {
                virkirTakkar.remove(event.getCode());

                if (virkirTakkar.isEmpty()) {
                    return Stefna.KYRR;
                } else {
                    // Find next currently held key to update direction
                    KeyCode naestiTakki = virkirTakkar.keySet().iterator().next();
                    return attir.get(naestiTakki);
                }
            }
        }
        return null;
    }

    /**
     * Returns the player's current score.
     *
     * @return the score
     */
    public int getStig() {
        return stig.get();
    }

    /**
     * Returns the score as a property, allowing listeners to observe changes.
     *
     * @return the score property
     */
    public SimpleIntegerProperty stigProperty() {
        return stig;
    }

    /**
     * Sets the player's score.
     *
     * @param stig the new score
     */
    public void setStig(int stig) {
        this.stig.set(stig);
    }
}
