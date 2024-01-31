package lesson_15;

import java.util.ArrayList;

public class JavaStreamTime {
    public static void main(String[] args) {
        int count = 1000;

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < count; i++){
            list.add((int) (Math.random() * 50));
        }

        long start = System.currentTimeMillis();

        list.stream().peek(e -> {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).forEach(System.out::println);

        long finish = System.currentTimeMillis() - start;

        long startP = System.currentTimeMillis();

        list.stream().parallel().sorted().peek(e -> {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).forEachOrdered(System.out::println);

        long finishP = System.currentTimeMillis() - startP;


        System.out.println("--------");


        System.out.println("s : " + finish);
        System.out.println("ps : " + finishP);
    }
}
