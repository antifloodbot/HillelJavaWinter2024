package lesson_04;

public class StackOverFlowE {
    public static int counter = 0;

    public static void main(SystemOutPrint[] args) {
        StackOverFlowE.run();
    }

    public static void run (){
        Integer i = 1000;
        System.out.println(counter++);
        run();
    }
}
