package lesson_19.io;

public class InputParams {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("incorrect parameters number");
        }

        System.out.println("OS: " + args[0]);
        System.out.println("RAM: " + args[1]);
        System.out.println("CPU: " + args[2]);
    }
}
