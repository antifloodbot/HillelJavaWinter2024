package lesson_04;

public class Konstr {
    int a; // 0
    int b; // 0

    public Konstr() {
    }

    public Konstr(int a) {
        System.out.println("konstr : a");
        this.a = a;

    }

    public Konstr(int a, int b) {
//        this(a); // go to line 10
        System.out.println("konstr : a, b ");
        this.a = a;
        this.b = b;
    }

    void printParam(){
        System.out.println("a = " + a + "; b = " + b);
    }
}
