import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("E");
        list.add("I");
        list.add("O");
        list.add("U");
        list.addAll(list.subList(0,4));
        System.out.println(list);

        List<Integer> list2 = new ArrayList<>();
        list2.add(15);
        list2.add(25);
        list2.add(15);
        list2.add(25);
        list2.remove(Integer.valueOf(15));
        System.out.println(list2);

        int i = 10;
        System.out.println(i > 3 != false);

        String javaworld = "JavaWorld";
        String java = "Java";
        String world = "World";
        java += world;
        System.out.println(java == javaworld);
    }
}
