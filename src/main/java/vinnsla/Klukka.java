package vinnsla;


import javafx.beans.property.SimpleIntegerProperty;

/**
 * Represents the game timer. Counts down each second and exposes the time as a property.
 */
public class Klukka {
    private final SimpleIntegerProperty timi; // Simple Integer property for time

    /**
     * Instantiates a new Klukka.
     *
     * @param timi the time
     */
    public Klukka(int timi) {
        this.timi = new SimpleIntegerProperty(timi);
    }

    /**
     * Tic. is a method to countdown the time
     */
    public void tic() {
        timi.setValue(timi.getValue() - 1);
    }

    /**
     * Returns the current time remaining.
     *
     * @return the time in seconds
     */
    public int getTimi() {
        return timi.get();
    }

    /**
     * Returns the time as a property, allowing listeners to observe changes.
     *
     * @return the time property
     */
    public SimpleIntegerProperty getTimiProperty() {
        return timi;
    }
}
