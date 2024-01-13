package hw11.phonebook;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.add("John Snow", "123-456-7890");
        phonebook.add("Bruce Lee", "987-654-3210");
        phonebook.add("John Snow", "555-555-5555");

        Map<String, List<String>> allEntries = phonebook.getEntries();
        for (Map.Entry<String, List<String>> entry : allEntries.entrySet()) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println("Name: " + name);
            for (String phoneNumber : phoneNumbers) {
                System.out.println("Phone: " + phoneNumber);
            }
        }

        System.out.println("--------------------------");

        final String PHONE_NUMBERS_HEADER = "Phone numbers for ";
        final String NOT_FOUND_MESSAGE = " not found in the phonebook.";
        String searchName = "John Snow";
        Optional<List<String>> foundPhoneNumbers = phonebook.findAll(searchName);
        if (foundPhoneNumbers.isPresent()) {
            List<String> phoneNumbers = foundPhoneNumbers.get();
            System.out.println(PHONE_NUMBERS_HEADER + searchName + ":");
            for (String phoneNumber : phoneNumbers) {
                System.out.println(phoneNumber);
            }
        } else {
            System.out.println(searchName + NOT_FOUND_MESSAGE);
        }
    }
}
