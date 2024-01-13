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

        System.out.println("-----------Display first number of one record:");
        Optional<Record> foundRecord = phonebook.find(searchName);
        if (foundRecord.isPresent()) {
            Record record = foundRecord.get();
            System.out.println(PHONE_NUMBERS_HEADER + record.getName() + ":\n" + record.getPhoneNumber());
        } else {
            System.out.println(searchName + NOT_FOUND_MESSAGE);
        }

        System.out.println("-----------Display all numbers of one record:");
        Optional<List<Record>> foundRecordsOptional = phonebook.findAll(searchName);
        if (foundRecordsOptional.isPresent()) {
            List<Record> foundRecords = foundRecordsOptional.get();
            System.out.println(PHONE_NUMBERS_HEADER + searchName + ":");
            for (Record record : foundRecords) {
                System.out.println(record.getPhoneNumber());
            }
        } else {
            System.out.println(searchName + NOT_FOUND_MESSAGE);
        }
    }
}
