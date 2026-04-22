package vinnsla;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KlukkaTest {

    @Test
    void testKlukkaIsCreated() {
        Klukka klukka = new Klukka(60);
        assertNotNull(klukka);
    }
}