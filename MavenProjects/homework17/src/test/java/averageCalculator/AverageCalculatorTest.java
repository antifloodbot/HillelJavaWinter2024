package averageCalculator;

import exceptions.EmptyCollectionException;
import exceptions.NullCollectionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AverageCalculatorTest {
    @DisplayName("should calculate correct average")
    @Test
    void testCalculateCorrectAverage() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        AverageCalculator calculator = new AverageCalculator();
        double result = calculator.calculateAverage(numbers);

        assertEquals(3.0, result);
    }

    @DisplayName("should throw empty collection exception")
    @Test
    void testCalculateShouldThrowExceptionEmptyCollection() {
        List<Integer> numbers = Collections.emptyList();
        AverageCalculator calculator = new AverageCalculator();
        Exception exception = assertThrows(EmptyCollectionException.class, () -> {
            calculator.calculateAverage(numbers);
        });
        String expectedMessage = "Collection is empty";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @DisplayName("should throw null collection exception")
    @Test
    void testCalculateAverageThrowsExceptionForNullElements() {
        AverageCalculator calculator = new AverageCalculator();
        List<Integer> numbersWithNull = Arrays.asList(1, 2, null, 4, 5);
        Exception exception = assertThrows(NullCollectionException.class, () -> {
            calculator.calculateAverage(numbersWithNull);
        });

        String expectedMessage = "Collection contains null elements";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}