package vinnsla;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeikurTest {

    @Test
    void leikurStartsWithDefaultDifficultyZero() {
        Leikur leikur = new Leikur();

        assertEquals(0, leikur.getErfidleikastig());
    }

    @Test
    void setErfidleikastigUpdatesDifficulty() {
        Leikur leikur = new Leikur();

        leikur.setErfidleikastig(2);

        assertEquals(2, leikur.getErfidleikastig());
    }

    @Test
    void leikurHasExpectedTimes() {
        Leikur leikur = new Leikur();

        assertArrayEquals(new int[]{60, 45, 30}, leikur.getTimar());
    }

    @Test
    void leikurCreatesKlukka() {
        Leikur leikur = new Leikur();

        assertNotNull(leikur.getKlukka());
        assertEquals(0, leikur.getKlukka().getTimi());
    }

    @Test
    void leikurCreatesTwoPlayers() {
        Leikur leikur = new Leikur();

        assertNotNull(leikur.getSpilari1());
        assertNotNull(leikur.getSpilari2());
    }

    @Test
    void tveirSpilararIsFalseByDefault() {
        Leikur leikur = new Leikur();

        assertFalse(leikur.isTveirSpilarar());
    }
}