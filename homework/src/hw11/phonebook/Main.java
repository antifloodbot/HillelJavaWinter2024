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
        String searchName = "John Snow";
        final String PHONE_NUMBERS_HEADER = "Phone numbers for ";
        final String NOT_FOUND_MESSAGE = " not found in the phonebook.";

        System.out.println("----------Display whole book:");
        Map<String, List<String>> allEntries = phonebook.getEntries();
        for (Map.Entry<String, List<String>> entry : allEntries.entrySet()) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println("Name: " + name);
            for (String phoneNumber : phoneNumbers) {
                System.out.println("Phone: " + phoneNumber);
            }
        }

        System.out.println("-----------Display first number---------------");
        Optional<String> findByName = phonebook.find(searchName);
        if (findByName.isPresent()) {
            String phoneNumber = findByName.get();
            System.out.println(PHONE_NUMBERS_HEADER + searchName + ": " + phoneNumber);
        } else {
            System.out.println(searchName + NOT_FOUND_MESSAGE);
        }

        System.out.println("-----------Display all numbers--------------");

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
