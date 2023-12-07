package lesson_03;

public class ExReverse {
    public static void main(String[] args) {
        System.out.println(reverse(111123445));
        System.out.println(reverse(2244));
        System.out.println(reverse(22544));

    }

    private static Integer reverse(Integer i) {
        char[] charArray = String.valueOf(i).toCharArray();
        for (int j = 0; j < charArray.length / 2; j++) {
            swap(charArray, j);
        }
        return Integer.valueOf(new String(charArray));
    }

    private static void swap(char[] charArray, int j) {
        char tmp = charArray[charArray.length- j - 1];
        charArray[charArray.length- j - 1] = charArray[j];
        charArray[j] = tmp;
    }
}
