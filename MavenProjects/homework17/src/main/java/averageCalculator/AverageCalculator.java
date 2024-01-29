package averageCalculator;

import exceptions.EmptyCollectionException;
import exceptions.NullCollectionException;

import java.util.List;

public class AverageCalculator {
    public double calculateAverage(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new EmptyCollectionException("Collection is empty");
        }
        if (numbers.contains(null)) {
            throw new NullCollectionException("Collection contains null elements");
        }
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
    }
}
