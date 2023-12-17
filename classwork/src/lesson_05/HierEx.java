package lesson_05;

public class HierEx {
    public static void main(String[] args) {
        Hier h = new Hier();
        Hier h1 = new Hier();
        h.setName("Alex");
        h1.setName("Alex");

        System.out.println(h.getClass().getName());

        System.out.println("Variable h =" + h);
        System.out.println("Variable h1 =" + h1);

        System.out.println(h.hashCode());

        System.out.println(h1 == h);
        System.out.println(h1.equals(h));

    }
}
