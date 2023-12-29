package lesson_08.list;

import java.util.ArrayList;
import java.util.List;

public class ALT {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        strList.add("1");
        strList.add("2");
        strList.add("3");
        strList.add("4");
        System.out.println(strList);

        strList.set(1, "set");
        System.out.println(strList); // change element
        strList.add(1, "add");
        System.out.println(strList); // add element
    }
}
