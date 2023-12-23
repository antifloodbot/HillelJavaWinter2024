package hw9;

import java.util.ArrayList;
import java.util.List;

public class StringCollectionService {
    private List<String> collection;

    public StringCollectionService() {
        this.collection = new ArrayList<>();
    }

    public boolean add(int index, String value) {
        if (index >= 0 && index <= collection.size()) {
            collection.add(index, value);
            return true;
        } else {
            return false;
        }
    }

    public boolean add(String value) {
        return collection.add(value);
    }

    public boolean delete(int index) {
        if (index >= 0 && index < collection.size()) {
            collection.remove(index);
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(String value) {
        return collection.remove(value);
    }

    public String get(int index) {
        if (index >= 0 && index < collection.size()) {
            return collection.get(index);

        }
        throw new IndexOutOfBoundsException("Index: " + index + " , Size: " + collection.size());
    }

    public void printCollection() {
        for (String str : collection) {
            System.out.print(str + ", ");
        }
    }
}
