package vinnsla;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeikurTest {

    @Test
    void testLeikurIsCreated() {
        Leikur leikur = new Leikur();
        assertNotNull(leikur);
    }
}