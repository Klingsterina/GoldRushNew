package vinnsla;

/**
 * Represents the game state. Holds the players, the clock, and the difficulty settings.
 */
public class Leikur {

    private int erfidleikastig = 0; // 3 difficulty levels 0,1,2
    public static boolean tveirSpilarar = false; //
    private final int[] timar = {60, 45, 30}; // Time in accordance with difficulty level
    private final Klukka klukka = new Klukka(0); // Makes a new clock
    private final Spilari spilari1 = new Spilari();
    private final Spilari spilari2 = new Spilari();

    /**
     * Returns player 1.
     *
     * @return spilari1
     */
    public Spilari getSpilari1() {
        return spilari1;
    }

    /**
     * Returns player 2.
     *
     * @return spilari2
     */
    public Spilari getSpilari2() {
        return spilari2;
    }

    /**
     * Returns the current difficulty level (0, 1, or 2).
     *
     * @return the difficulty level
     */
    public int getErfidleikastig() {
        return erfidleikastig;
    }

    /**
     * Sets the difficulty level.
     *
     * @param erfidleikastig the difficulty level (0, 1, or 2)
     */
    public void setErfidleikastig(int erfidleikastig) {
        this.erfidleikastig = erfidleikastig;
    }

    /**
     * Returns the time limits for each difficulty level in seconds.
     *
     * @return array of time limits indexed by difficulty level
     */
    public int[] getTimar() {
        return timar;
    }

    /**
     * Returns the game clock.
     *
     * @return the clock
     */
    public Klukka getKlukka() {
        return klukka;
    }

    /**
     * Returns whether two-player mode is active.
     *
     * @return true if two players, false if one player
     */
    public boolean isTveirSpilarar() {
        return tveirSpilarar;
    }
}
