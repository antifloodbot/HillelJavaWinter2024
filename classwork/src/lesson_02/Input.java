package lesson_02;

public class Input {
    public static void main(String[] args) {
        int sum = 0;
        System.out.println("input array size : " + args.length);

        for (String str : args) {
            System.out.println(str);
            int intValue = Integer.parseInt(str);
            //sum = sum + i;
            sum += intValue;
        }
        System.out.println("----------------");
        System.out.println("result: " + sum);
    }
}
