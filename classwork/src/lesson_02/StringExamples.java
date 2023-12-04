package lesson_02;

public class StringExamples {
    public static void main(String[] args) {
        String str1 = "String ,...string"; //99%
        String str2 = new String("new String");
        String str3 = new String(new char[]{'S', 't', 'r', 'i', 'n', 'g'});
        String str4 = new String(new char[]{'S', 't', 'r', 'i', 'n', 'g'}, 3, 3);

        System.out.println(str1.length());
        char[] chars = str1.toCharArray();

        String empty = "   ";
        System.out.println(empty.length() == 0);
        System.out.println(empty.isEmpty());
        System.out.println(empty.isBlank());

        System.out.println(str4);

        String s1 = "a";
        String s2 = "b";
        String s3 = "c";
        System.out.println(s1.concat(s2).concat(s3));

        Integer i = 10;
        String iString = String.valueOf(i);
        System.out.println(String.valueOf(i));
        String joinString = String.join(":", s1, s2, s3);
        System.out.println(joinString);

        s1 = "test";
        s2 = "test";
        System.out.println(s1.compareTo(s2));
        System.out.println(s1.equals(s2));
        System.out.println(s1.charAt(s1.length() - 1)); // start with 0

        char[] arr = new char[3];
        s1.getChars(0, 3, arr, 0);
        System.out.println(new String(arr));

        s1 = "TesT";
        s2 = "test";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        System.out.println(s1.indexOf("T"));
        System.out.println(s1.lastIndexOf("T"));
        System.out.println(s1.indexOf("F"));

        System.out.println(s1.startsWith("Tes"));
        System.out.println(s1.endsWith("t"));

        System.out.println(s1.replace('e', 'E'));

        s1 = "  test";
        s2 = "test  ";
        s3 = " test ";
        System.out.println(s1.trim());
        System.out.println(s2.trim());
        System.out.println(s3.trim());

        System.out.println(empty.length());
        String e = empty.trim();
        System.out.println(e.length());

        System.out.println(s1.substring(3, 5)); // [including 3 excluding 5 .. )

        s1 = "tEsT StRiNg";

        System.out.println(s1.toUpperCase());
        System.out.println(s1.toLowerCase());
    }
}
