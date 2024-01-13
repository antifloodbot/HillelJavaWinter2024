package hw11.occurance;

import java.util.*;

public class Occurrence {
    public int countOccurrence(List<String> list, String target) {
        int count = 0;
        for (String item : list) {
            if (item.equals(target)) {
                count++;
            }
        }
        return count;
    }

    public List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int item : array) {
            list.add(item);
        }
        return list;
    }

    public List<Integer> findUnique(List<Integer> list) {
        Set<Integer> newList = new HashSet<>(list);
        return new ArrayList<>(newList);
    }

    public void calcOccurrence(List<String> words) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
