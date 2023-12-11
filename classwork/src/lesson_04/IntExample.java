package lesson_04;

public class IntExample {
    public static void main(SystemOutPrint[] args) {

        Integer i1 = 128;
        Integer i2 = 128;
        Integer i3 = 127;

        System.out.println(i1 == i2);
        System.out.println(i1 == i3);
    }

    static void printA (int a){
        System.out.println(a);
    }

    static void printI (Integer a){
        a = 15;
        System.out.println(a);
    }
}
