package lesson_04;

public class Calc {
    public static void main(String[] args) {
    if (args.length != 3) {
        System.out.println("Incorrect input data ...");
        System.exit(-1);
    }

    Integer a = Integer.parseInt(args[0]);
    Integer b = Integer.parseInt(args[2]);


        switch (args[1]) {
        case "+":
            System.out.println(sum(a, b));
            break;
        case "-":
            System.out.println(sub(a, b));
            break;
        case "*":
            System.out.println(mul(a, b));
            break;
        case "/": {
            if (b == 0) {
                System.out.println("Divide by Zero prohibited operation ...");
                break;
            } else {
                System.out.println(div(a, b));
                break;
            }
        }

        default:
            System.out.println("incorrect operation ...");
    }
}

    static Integer sum(int a, int b) {
        return a + b;
    }

    static Integer sub(int a, int b) {
        return a - b;
    }

    static Integer mul(int a, int b) {
        return a * b;
    }

    static Integer div(int a, int b) {
        return a / b;
    }


}
