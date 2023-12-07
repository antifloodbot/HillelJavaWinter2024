package lesson_03;

public class IfElse {
    public static void main(String[] args) {
        int a = 20;
        int b = 20;

        if (compare(a, b)) {
            //a < b
            System.out.println("TRUE"); // goto: 27
        } else if (a == b) {
            // a = b
            System.out.println("=="); // goto: 27
        } else {
            // b > a
            System.out.println("FALSE"); // goto: 27
        }

        // Ternar operator
        boolean rez = (a > b) ? true : false; // condition ? true : false
        System.out.println(false ? print1() : print2());

        if (compare(a, b))
            System.out.println("smth"); // if
        System.out.println("sss"); // not if

    }

    static boolean compare(int a, int b) {
        return a < b;
    }

    static String print1() {
        System.out.println("print1");
        return "1";
    }

    static String print2() {
        System.out.println("print2");
        return "2";
    }
}
