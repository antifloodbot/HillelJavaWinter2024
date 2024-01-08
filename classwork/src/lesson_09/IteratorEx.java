package lesson_09;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorEx {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("1");
        collection.add("2");
        collection.add("3");

        Iterator<String> iterator = collection.iterator();

        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
        }
    }
}
