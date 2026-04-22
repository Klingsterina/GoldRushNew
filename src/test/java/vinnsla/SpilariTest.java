package vinnsla;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpilariTest {

    @Test
    void spilariStartsWithZeroScore() {
        Spilari spilari = new Spilari();

        assertEquals(0, spilari.getStig());
    }

    @Test
    void setStigUpdatesScore() {
        Spilari spilari = new Spilari();

        spilari.setStig(15);

        assertEquals(15, spilari.getStig());
    }

    @Test
    void stigPropertyMatchesScore() {
        Spilari spilari = new Spilari();

        spilari.setStig(42);

        assertEquals(42, spilari.stigProperty().get());
    }
}