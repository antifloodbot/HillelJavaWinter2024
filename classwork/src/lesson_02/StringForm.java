package lesson_02;

public class StringForm {
    public static void main(String[] args) {
        String s1 = String.format("Hello %s", args[0]); // new object in heap
        String s2 = String.format("Hello %s", args[0]); // new object in heap

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1);
    }
}
