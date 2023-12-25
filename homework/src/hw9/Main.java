package hw9;

public class Main {
    public static void main(String[] args) {
        DynamicStringArray dynamicArray = new DynamicStringArray();

        dynamicArray.add(0, "First");
        dynamicArray.add(1, "Second");
        dynamicArray.add(1, "Third");

        System.out.println("Getting element with index 1:\n" + dynamicArray.get(1));
        System.out.println("The whole array:\n" + dynamicArray);

        dynamicArray.add("olala");
        System.out.println("Getting the whole array after adding 'olala':\n" + dynamicArray);

        dynamicArray.delete(1);
        System.out.println("Getting the whole array after deleting value of index 1:\n" + dynamicArray);

        dynamicArray.delete("First");
        System.out.println("Getting the whole array after deleting 'First':\n" + dynamicArray);
    }
}
