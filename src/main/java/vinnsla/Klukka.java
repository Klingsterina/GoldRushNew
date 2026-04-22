package vinnsla;


import javafx.beans.property.SimpleIntegerProperty;

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

    public int getTimi() {
        return timi.get();
    }

    public SimpleIntegerProperty getTimiProperty() {
        return timi;
    }
}
