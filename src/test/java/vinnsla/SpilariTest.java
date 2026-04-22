package vinnsla;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.junit.jupiter.api.Test;
import vidmot.Stefna;

import static org.junit.jupiter.api.Assertions.*;

class SpilariTest {

    private KeyEvent keyPressed(KeyCode keyCode) {
        return new KeyEvent(
                KeyEvent.KEY_PRESSED,
                "",
                "",
                keyCode,
                false,
                false,
                false,
                false
        );
    }

    private KeyEvent keyReleased(KeyCode keyCode) {
        return new KeyEvent(
                KeyEvent.KEY_RELEASED,
                "",
                "",
                keyCode,
                false,
                false,
                false,
                false
        );
    }

    /**
     * Verifies that a new player starts with 0 points.
     */
    @Test
    void testScore() {
        Spilari spilari = new Spilari();

        assertEquals(0, spilari.getStig());
    }

    /**
     * Verifies that setStig() updates the player's score correctly.
     */
    @Test
    void testSetScore() {
        Spilari spilari = new Spilari();

        spilari.setStig(15);

        assertEquals(15, spilari.getStig());
    }

    /**
     * Verifies that stigProperty() reflects the current score.
     */
    @Test
    void testProperty() {
        Spilari spilari = new Spilari();

        spilari.setStig(42);

        assertEquals(42, spilari.stigProperty().get());
    }

    /**
     * Verifies that pressing a mapped key returns the correct direction
     * and stores the key as active.
     */
    @Test
    void testPressKey() {
        Spilari spilari = new Spilari();
        spilari.attir.put(KeyCode.W, Stefna.UPP);

        Stefna result = spilari.yttATakka(keyPressed(KeyCode.W));

        assertEquals(Stefna.UPP, result);
        assertTrue(spilari.virkirTakkar.containsKey(KeyCode.W));
    }

    /**
     * Verifies that pressing an unmapped key returns null
     * and does not store any active key.
     */
    @Test
    void testWrongKey() {
        Spilari spilari = new Spilari();
        spilari.attir.put(KeyCode.W, Stefna.UPP);

        Stefna result = spilari.yttATakka(keyPressed(KeyCode.A));

        assertNull(result);
        assertTrue(spilari.virkirTakkar.isEmpty());
    }

    /**
     * Verifies that releasing the last active key returns KYRR
     * and clears the active key collection.
     */
    @Test
    void testReleaseLastKey() {
        Spilari spilari = new Spilari();
        spilari.attir.put(KeyCode.W, Stefna.UPP);

        spilari.yttATakka(keyPressed(KeyCode.W));
        Stefna result = spilari.yttATakka(keyReleased(KeyCode.W));

        assertEquals(Stefna.KYRR, result);
        assertTrue(spilari.virkirTakkar.isEmpty());
    }

    /**
     * Verifies that releasing one key while another is still pressed
     * returns the direction of the remaining active key.
     */
    @Test
    void testReleaseOneKey() {
        Spilari spilari = new Spilari();
        spilari.attir.put(KeyCode.W, Stefna.UPP);
        spilari.attir.put(KeyCode.D, Stefna.HAEGRI);

        spilari.yttATakka(keyPressed(KeyCode.W));
        spilari.yttATakka(keyPressed(KeyCode.D));

        Stefna result = spilari.yttATakka(keyReleased(KeyCode.D));

        assertEquals(Stefna.UPP, result);
        assertTrue(spilari.virkirTakkar.containsKey(KeyCode.W));
        assertFalse(spilari.virkirTakkar.containsKey(KeyCode.D));
    }
}