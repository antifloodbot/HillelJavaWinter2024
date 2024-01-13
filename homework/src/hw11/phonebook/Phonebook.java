package hw11.phonebook;

import java.util.*;

public class Phonebook {
    private Map<String, List<String>> entries;

    public Phonebook() {
        this.entries = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        if (!entries.containsKey(name)) {
            entries.put(name, new ArrayList<>());
        }
        entries.get(name).add(phoneNumber);
    }

    public Optional<String> find(String name) {
        if (entries.containsKey(name)) {
            List<String> entryList = entries.get(name);
            if (!entryList.isEmpty()) {
                return Optional.of(entryList.get(0));
            }
        }
        return Optional.empty();
    }

    public Optional<List<String>> findAll(String name) {
        if (entries.containsKey(name)) {
            return Optional.of(entries.get(name));
        }
        return Optional.empty();
    }

    public Map<String, List<String>> getEntries() {
        return entries;
    }
}
