package hw11.occurance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindOccurrence {
    private String name;
    private int occurrence;

    public FindOccurrence(){};

    public FindOccurrence(String name, int occurrence) {
        this.name = name;
        this.occurrence = occurrence;
    }

    public String getName() {
        return name;
    }

    public List<FindOccurrence> findOccurrence(List<String> words) {
        Map<String, Integer> occurrencesMap = new HashMap<>();
        for (String word : words) {
            occurrencesMap.put(word, occurrencesMap.getOrDefault(word, 0) + 1);
        }
        List<FindOccurrence> occurrenceList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : occurrencesMap.entrySet()) {
            occurrenceList.add(new FindOccurrence(entry.getKey(), entry.getValue()));
        }
        return occurrenceList;
    }

    @Override
    public String toString() {
        return "{name: \"" + name + "\", occurrence: " + occurrence + "}";
    }

}
