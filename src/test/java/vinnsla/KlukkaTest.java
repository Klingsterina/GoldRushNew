package vinnsla;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KlukkaTest {

    @Test
    void klukkaIsCreatedWithGivenTime() {
        Klukka klukka = new Klukka(60);

        assertEquals(60, klukka.getTimi());
    }

    @Test
    void ticDecrementsTimeByOne() {
        Klukka klukka = new Klukka(10);

        klukka.tic();

        assertEquals(9, klukka.getTimi());
    }

    @Test
    void timiPropertyMatchesValue() {
        Klukka klukka = new Klukka(25);

        assertEquals(25, klukka.getTimiProperty().get());
    }
}