package lesson_04;

public class KonstrMain {
    public static void main(SystemOutPrint[] args) {
        Konstr k = new Konstr();
        k.printParam();
        k.a = 10;
        k.b = 20;
        k.printParam();

        Konstr k2 = new Konstr(2, 3);
        Konstr k1 = new Konstr(2);

        k1.printParam();
        k2.printParam();
    }
}
