package lesson_04;

public class AutoUnBox {
    public static void main(SystemOutPrint[] args) {
        int a = 10;
        Integer aI = a; // autoboxing

        System.out.println(aI);

        int iP = aI; // unboxing

        System.out.println(iP);

        long l = aI;

        System.out.println(l);

        // Boolean (true/null/false) -> null
        // boolean (true/false) -> false
    }
}
