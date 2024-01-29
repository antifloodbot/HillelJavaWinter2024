package convertToPair;

import exceptions.EmptyCollectionException;
import exceptions.NullCollectionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConvertToPairTest {
    private ConvertToPair converter;
    private List<String> strings;

    @BeforeEach
    void setUp() {
        converter = new ConvertToPair();
        strings = new ArrayList<>();
    }

    @DisplayName("positive flow test")
    @Test
    void testPositiveFlow() {
        strings.add("one");
        strings.add("TWO");
        strings.add("thrEe");

        List<AbstractMap.SimpleEntry<String, String>> pairs = converter.convertToUpperCasePairs(strings);

        assertNotNull(pairs);
        assertFalse(pairs.isEmpty());

        for (AbstractMap.SimpleEntry<String, String> pair : pairs) {
            assertNotNull(pair);
            assertNotNull(pair.getKey());
            assertNotNull(pair.getValue());
            assertEquals(pair.getKey().toUpperCase(), pair.getValue());
        }
    }

    @DisplayName("custom null pointer exception test")
    @Test
    void testCustomNullPointerException() {
        List<String> strings = Arrays.asList("one", null);

        assertThrows(NullCollectionException.class, () -> {
            converter.convertToUpperCasePairs(strings);
        });
    }

    @DisplayName("custom empty collection exception test")
    @Test
    void testCustomEmptyCollectionException() {
        strings = new ArrayList<>();
        assertThrows(EmptyCollectionException.class, () -> {
            converter.convertToUpperCasePairs(strings);
        });
    }
}