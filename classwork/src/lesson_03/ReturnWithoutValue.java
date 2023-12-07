package lesson_03;

public class ReturnWithoutValue {
    public static void main(String[] args) {
        int a = 10;
        if (a % 2 == 0) {
            return;
        } else {
            System.out.println("ODD");
        }
        System.out.println("finish program");
    }
}
