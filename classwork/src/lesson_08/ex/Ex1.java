package lesson_08.ex;

public class Ex1 extends Foo {
    public static String sign() {
        System.out.println("ex1");
        return "fa";
    }

    public static void main(String[] args) {
        Ex1 ex = new Ex1();
        Foo foo = new Foo();
        Foo foo2 = (Foo) ex;
        //Ex1 e = (Ex1) new Foo();
        System.out.println(ex.sign() + " " + foo.sign());
        System.out.println(foo instanceof Foo);
    }
}

class Foo {
    public static String sign() {
        System.out.println("Foo");
        return "la";
    }
}
