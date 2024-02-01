package com.unit.stream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangeWordInTextTest {
    static String TEXT = "test_word";
    static String TEXT_EXAMPLE = "test word";
    static String EXP_RESULT = "test_word test_word";

    @Test
    void changeWordInText() {
        ChangeWordInText cwt = new ChangeWordInText();
        assertTrue(EXP_RESULT.equals(cwt.changeText(TEXT_EXAMPLE, TEXT, 4L)));
        assertEquals(EXP_RESULT, cwt.changeText(TEXT_EXAMPLE, TEXT, 4L));
    }

    @Test
    void changeWordInTextNothing() {
        ChangeWordInText cwt = new ChangeWordInText();
        assertTrue(TEXT_EXAMPLE.equals(cwt.changeText(TEXT_EXAMPLE, TEXT, 5L)));
        assertEquals(TEXT_EXAMPLE, cwt.changeText(TEXT_EXAMPLE, TEXT, 5L));
    }
}