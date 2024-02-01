package com.unit.stream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangeWordPlaceTest {

    private static String EX = "1 2 3 4. 2 3 4. 3 4 5. 6 7. 1";
    private static String REZ = "4 2 3 1. 4 3 2. 5 4 3. 7 6. 1";

    @Test
    void changeWordOrder() {
        ChangeWordPlace cwp = new ChangeWordPlace();
        assertTrue(REZ.equals(cwp.changeWordOrder(EX)));
        assertEquals(REZ, cwp.changeWordOrder(EX));
    }
}