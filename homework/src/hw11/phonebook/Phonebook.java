package hw11.phonebook;

import java.util.*;

public class Phonebook {
    private List<Record> records;

    public Phonebook() {
        records = new ArrayList<>();
    }

    public void add(String name, String phoneNumber) {
        Record record = new Record(name, phoneNumber);
        records.add(record);
    }

    public Optional<Record> find(String name) {
        for (Record record : records) {
            if (record.getName().equals(name)) {
                return Optional.of(record);
            }
        }
        return Optional.empty();
    }

    public Optional<List<Record>> findAll(String name) {
        List<Record> foundRecords = new ArrayList<>();
        for (Record record : records) {
            if (record.getName().equals(name)) {
                foundRecords.add(record);
            }
        }
        return foundRecords.isEmpty() ? Optional.empty() : Optional.of(foundRecords);
    }
}
