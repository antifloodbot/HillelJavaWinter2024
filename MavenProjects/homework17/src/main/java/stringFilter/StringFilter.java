package stringFilter;

import exceptions.EmptyCollectionException;
import exceptions.NullCollectionException;

import java.util.List;

public class StringFilter {
    public List<String> filterAndPrintLowerCase4Length(List<String> strings) throws EmptyCollectionException, NullCollectionException {
        if (strings.contains(null)) {
            throw new NullCollectionException("Collection contains null elements");
        }
        if (strings.isEmpty()) {
            throw new EmptyCollectionException("Collection contains null elements");
        }
        List<String> filteredStrings = strings.stream()
                .filter(str -> str.equals(str.toLowerCase()) && str.length() == 4)
                .toList();
        return filteredStrings;
    }
}
