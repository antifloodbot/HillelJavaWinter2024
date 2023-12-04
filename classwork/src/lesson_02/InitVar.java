package lesson_02;

public class InitVar {
    public static void main(String[] args) {
        int a = 10; // prim integer
        double d;

        byte b = (byte) valueCalculate(); // -128 == 127 (256 with 0)

        System.out.println(a);
        System.out.println(b);

        a = 35;
        System.out.println(a);

        d = 3.3d;
        System.out.println("double d: " + d);

        int d1 = (int) d;
        System.out.println("int d: " + d1);

        long l = 1234523534636789L;

        int longInt = (int) l;
        System.out.println(l);
        System.out.println(longInt);

    }
    private static int valueCalculate(){
        return 258; // > 128
    }
}
