package hw11.occurance;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Occurrence occurrence = new Occurrence();
        List<String> wordsToCount = List.of("iphone", "pixel", "nokia", "iphone", "samsung");
        String targetWord = "iphone";
        int occurrenceCount = occurrence.countOccurrence(wordsToCount, targetWord);
        System.out.println("The word '" + targetWord + "' occurred " + occurrenceCount + " times.");

        int[] numbers = {1,2,3,4,5,6};
        Occurrence arrayToList = new Occurrence();
        List<Integer> list = arrayToList.toList(numbers);
        System.out.println("List: " + list);

        List<Integer> listOfNumbers = List.of(1,2,3,4,5,5,5,6,6,2,3,4,1);
        Occurrence newList = new Occurrence();
        List<Integer> newUniqueList = newList.findUnique(listOfNumbers);
        System.out.println("New list with unique numbers: " + newUniqueList);

        List<String> wordsToCalc = List.of("car", "map", "bike", "money", "laptop", "iphone", "car", "bike", "tv", "car");
        Occurrence calcOccurrence = new Occurrence();
        System.out.println("\nResult is :");
        calcOccurrence.calcOccurrence(wordsToCalc);

        FindOccurrence findOccurrence = new FindOccurrence();
        List<FindOccurrence> occurrenceList = findOccurrence.findOccurrence(wordsToCalc);
        String formattedList = occurrenceList.stream()
                .map(FindOccurrence::toString)
                .collect(Collectors.joining(", \n", "[\n", "\n]"));
        System.out.println("List is:\n" + formattedList);
    }
}
