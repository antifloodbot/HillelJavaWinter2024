package stringFilter;

import exceptions.EmptyCollectionException;
import exceptions.NullCollectionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringFilterTest {
    private StringFilter stringFilter;
    private List<String> emptyList;

    @BeforeEach
    void setUp() {
        stringFilter = new StringFilter();
    }

    @DisplayName("positive flow test")
    @Test
    void testPositiveFlow() {
        List<String> strings = Arrays.asList("one", "two", "three", "four", "five", "Five");
        List<String> filterStrings = stringFilter.filterAndPrintLowerCase4Length(strings);
        List<String> expectedOutput = Arrays.asList("four", "five");

        assertEquals(expectedOutput, filterStrings);
    }

    @DisplayName("should throw null collection exceptio")
    @Test
    void testChecksCollectionContainsNull() {
        List<String> strings = Arrays.asList("olala", "null", null);

        assertThrows(NullCollectionException.class, () -> {
            stringFilter.filterAndPrintLowerCase4Length(strings);
        });
    }

    @DisplayName("should throw empty collection exception")
    @Test
    void testChecksEmptyCollection() {
        emptyList = new ArrayList<>();

        assertThrows(EmptyCollectionException.class, () -> {
            stringFilter.filterAndPrintLowerCase4Length(emptyList);
        });
    }
}