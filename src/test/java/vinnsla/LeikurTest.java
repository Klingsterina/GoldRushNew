package vinnsla;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeikurTest {

    /**
     * Verifies that a new game starts with difficulty level 0.
     */
    @Test
    void testDifficulty() {
        Leikur leikur = new Leikur();

        assertEquals(0, leikur.getErfidleikastig());
    }

    /**
     * Verifies that setErfidleikastig() updates the difficulty correctly.
     */
    @Test
    void testSetDifficulty() {
        Leikur leikur = new Leikur();

        leikur.setErfidleikastig(2);

        assertEquals(2, leikur.getErfidleikastig());
    }

    /**
     * Verifies that the game contains the expected time values.
     */
    @Test
    void testTimes() {
        Leikur leikur = new Leikur();

        assertArrayEquals(new int[]{60, 45, 30}, leikur.getTimar());
    }

    /**
     * Verifies that a new game creates a clock
     * and that its initial time is 0.
     */
    @Test
    void testClock() {
        Leikur leikur = new Leikur();

        assertNotNull(leikur.getKlukka());
        assertEquals(0, leikur.getKlukka().getTimi());
    }

    /**
     * Verifies that a new game creates two player objects.
     */
    @Test
    void testPlayers() {
        Leikur leikur = new Leikur();

        assertNotNull(leikur.getSpilari1());
        assertNotNull(leikur.getSpilari2());
    }

    /**
     * Verifies that the two players are different objects.
     */
    @Test
    void testDifferentPlayers() {
        Leikur leikur = new Leikur();

        assertNotSame(leikur.getSpilari1(), leikur.getSpilari2());
    }

    /**
     * Verifies that changing one player's score
     * does not affect the other player.
     */
    @Test
    void testPlayerScores() {
        Leikur leikur = new Leikur();

        leikur.getSpilari1().setStig(10);

        assertEquals(10, leikur.getSpilari1().getStig());
        assertEquals(0, leikur.getSpilari2().getStig());
    }

    /**
     * Verifies that two-player mode is false by default.
     */
    @Test
    void testTwoPlayers() {
        Leikur leikur = new Leikur();

        assertFalse(leikur.isTveirSpilarar());
    }
}