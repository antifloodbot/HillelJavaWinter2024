package lesson_03;

public class WhileEx {
    public static void main(String[] args) {
        whileExample();
        System.out.println();
        System.out.println("-------");
        doWhileExample();
    }

    static void whileExample(){
        byte a = 5;
        byte result = 0;
        a = print(a); // dubl
        while (a < 10) { // false then nothing
            a = print(a); // dubl
            System.out.println(a);
        }
    }

    static void doWhileExample(){
        byte a = 10;
        byte result = 0;
        do {
            System.out.print(a++ + " ");
        } while (a < 100);
    }

    static byte print (byte b){
        System.out.println(b++);
        return b;
    }
}
