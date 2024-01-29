package convertToPair;

import exceptions.EmptyCollectionException;
import exceptions.NullCollectionException;

import java.util.AbstractMap;
import java.util.List;

public class ConvertToPair {
    public List<AbstractMap.SimpleEntry<String, String>> convertToUpperCasePairs(List<String> strings) throws EmptyCollectionException, NullCollectionException {
        if (strings.contains(null)) {
            throw new NullCollectionException("Collection contains null elements");
        }
        if (strings.isEmpty()) {
            throw new EmptyCollectionException("Collection is empty");
        }

        return strings.stream()
                .map(s -> new AbstractMap.SimpleEntry<>(s, s.toUpperCase()))
                .toList();
    }
}
