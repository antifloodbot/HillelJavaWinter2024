package lesson_08.list;

import java.util.Vector;

public class VectorEx {

    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        System.out.println(vector.size());
        System.out.println(vector.add("One"));
        System.out.println(vector.add("Two"));
        System.out.println(vector.add(null));
        System.out.println(vector.add("Three"));
        System.out.println(vector.size());
        System.out.println(vector);

        vector.remove("One");
        System.out.println(vector.toString());
        System.out.println(vector.size());
        vector.remove(1);
        System.out.println(vector.toString());

//        vector.add(10, "ten");

        System.out.println(vector.firstElement());
        System.out.println(vector.lastElement());
    }
}
