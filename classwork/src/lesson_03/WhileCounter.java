package lesson_03;

public class WhileCounter {
    public static void main(String[] args) {

        String pass = "wrong_pass";

        boolean result = false;
        int counter = 0;
        do {
            if (pass.equals("1111")) {
                result = true;
            }
            counter++;
            System.out.println(pass + " : " + result);

        } while (!result && counter < 5); // true -> false

    }
}
