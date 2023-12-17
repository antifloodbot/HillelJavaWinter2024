package lesson_05;

public class TestHI {
    public static void main(String[] args) {
        B b = new B();

        C c = new C();


        System.out.println(c.getA());
        System.out.println(c.getB());

        c.setA(1);
        c.setB(1);
        b.setA(2);
        b.setB(4);

        System.out.println(c.getA());
        System.out.println(c.getB());
        System.out.println(b.getA());
        System.out.println(b.getB());

    }
}

class B {
    private int a;
    private int b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}

class C extends B {
    private int c;

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}
