package lesson_02;

public class JavaTypesPrim {
    public static void main(String[] args) {

//        -128 .. 127 // 256
        byte bmin = -128;
        byte bmax = 127;

        int a = -130; // -128 -> (127-1) -> -1 (1260)
        int b = 630; // 127 -> +1 (-128) -> +1 (-127) -> +1 (-126)
        System.out.println((byte) a);
        System.out.println((byte) b);

        int d = 130;
        System.out.println((byte) d);

        short sh = 20000;

        long longValue = 5_000_000_000L;
        System.out.println(longValue);

        int aa = 66;
        char c = (char) a;

        char ch = 157;
        char ch1 = 'f';

        System.out.println(ch);
        System.out.println(ch1);
        System.out.println(c);

        long l = 100L;
        double db = 12d;
        float fl = 12f;

        boolean bool = true; // false

        //float -> double
    }
}
